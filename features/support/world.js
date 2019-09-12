const { setWorldConstructor } = require("cucumber");

class CustomWorld {
  constructor() {
    this.accountCodeToRequest = "";
    this.resultingWallet = undefined;

    this.addBalanceRequestObject = {
        accountCode : "",
        balanceToAdd : 0
    }
    this.resultingBalanceAdditionRequest = undefined;
  }

  setupWalletRequest(accountCode) {
    this.accountCodeToRequest = accountCode;
  }

  async requestWallet(httpClient){
    let httpOptions = {
        method: 'GET',
        uri: 'http://localhost:8080/WalletApp/api/wallet/' + this.accountCodeToRequest,
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
        uri: 'http://localhost:8080/WalletApp/api/wallet/add-balance',
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
}

setWorldConstructor(CustomWorld);