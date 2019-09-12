    const { setWorldConstructor } = require("cucumber");

    class CustomWorld {
    constructor() {
        this.appUrl = "http://localhost:8080/WalletApp/"
        this.accountCodeToRequest = "";
        this.resultingWallet = undefined;

        this.addBalanceRequestObject = {
            accountCode : "",
            balanceToAdd : 0
        }
        this.resultingBalanceAdditionRequest = undefined;

        this.loginData = {
            accountCode : "",
            pin : ""
        }
        this.chromeDriver = undefined;
    }

    setupWalletRequest(accountCode) {
        this.accountCodeToRequest = accountCode;
    }

    async requestWallet(httpClient){
        let httpOptions = {
            method: 'GET',
            uri: this.appUrl + 'api/wallet/' + this.accountCodeToRequest,
            json: true,
            resolveWithFullResponse: true
            };
        let self = this;
        await httpClient(httpOptions)
        .then(function(response) {
            self.setWalletResponse(response);
        })
        .catch(function(error) {
            self.setWalletResponse(error);
        });
    }

    setWalletResponse(response){
        this.resultingWallet = response;
    }

    setupInformationToAddBalance(accountCode, balanceToAdd){
        this.addBalanceRequestObject.accountCode = accountCode;
        this.addBalanceRequestObject.balanceToAdd = balanceToAdd;
    }

    async requestBalanceAddition(httpClient){
        let httpOptions = {
            method: 'POST',
            uri: this.appUrl + 'api/wallet/add-balance',
            json: true,
            body: this.addBalanceRequestObject,
            resolveWithFullResponse: true
            };
        let self = this;
        await httpClient(httpOptions)
        .then(function(response) {
            self.setAddtitionRequestResult(response);
        })
        .catch(function(error) {
            self.setAddtitionRequestResult(error);
        });
    }

    setAddtitionRequestResult(response){
    this.resultingBalanceAdditionRequest = response;
    }

    async navitageToLogin(chromeDriver){
        const loginUrl =  this.appUrl + "index.html"
        this.chromeDriver = chromeDriver;
        console.log("navigating to: " + loginUrl)
        await this.chromeDriver.get(loginUrl);
    }

    async putAccountCodeToLoginForm(By){
        await this.chromeDriver.findElement(By.id('inputAccountCode')).sendKeys(this.loginData.accountCode);
    }

    async putPinToLoginForm(By){
        await this.chromeDriver.findElement(By.id('inputPin')).sendKeys(this.loginData.pin);
    }

    async clickOnEnter(By, until){
        await this.chromeDriver.findElement(By.id('btn-enter')).click();
        
        await this.chromeDriver.sleep(2000)
        //await this.chromeDriver.wait(until.elementIsVisible(By.id('wallet-details')),1000);
    }

    async getAccountCodeLoggedIn(By){
        const showText = await this.chromeDriver.findElement(By.id('accountCode'))
            .getText().then(function (text) {
                return text;
            });
        return showText;
    }

    async getAccountBalanceLoggedIn(By){
        const showText = await this.chromeDriver.findElement(By.id('balance'))
            .getText().then(function (text) {
               return text;
            });
        return parseFloat(showText);
    }
}

setWorldConstructor(CustomWorld);