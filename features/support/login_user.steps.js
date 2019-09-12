const { Given, When, Then, setDefaultTimeout } = require('cucumber')
const { expect } = require('chai')
const { Builder, By, Key, until } = require('selenium-webdriver');
const chrome = require('selenium-webdriver/chrome');
const chromedriver = require('chromedriver');

setDefaultTimeout(60 * 1000);

Given('Dados datos de usuario accountCode: {string} y PIN: {string}', function (accountCode, pin) {
    this.loginData.accountCode = accountCode;
    this.loginData.pin = pin;
});

When('Navego a la pagina de login', async function () {
    let chromeDriver = await new Builder().forBrowser('chrome').build();
    await this.navitageToLogin(chromeDriver);
});


When('Llenar el campo de Account Code', async function () {
    await this.putAccountCodeToLoginForm(By)
});

When('Llenar el campo de PIN', async function () {
    await this.putPinToLoginForm(By)
});

When('Hacer click en el boton Enter', async function () {
    await this.clickOnEnter(By, until)
});

Then('Se debe mostrar la cadena {string} en el valor Account Code', async function (expectedAccountCode) {
    let accountCode = await this.getAccountCodeLoggedIn(By)
    expect(accountCode).to.eql(expectedAccountCode);
});

Then('Debe haber un numero mayor o igual que {int} en el valor Balance', async function (expectedValue) {
    let balance = await this.getAccountBalanceLoggedIn(By)
    expect(balance).to.least(expectedValue);
    await this.chromeDriver.quit();
});