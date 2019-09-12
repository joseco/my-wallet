const { Given, When, Then } = require('cucumber')
const { expect } = require('chai')
const httpClient = require('request-promise')

Given('El codigo de cuenta de billetera {string}', function (accountCode) {
    this.setupWalletRequest(accountCode);
});



When('Hago la peticion HTTP al endpoint de consulta', async function () {
    await this.requestWallet(httpClient);
});

Then('Obtengo una respuesta http status {int} junto con el JSON de Respuesta', function (expectedStatusCode) {
    expect(this.resultingWallet.statusCode).to.eql(expectedStatusCode);
});

Then('Comparo que el accountCode obtenido sea {string}', function (expectedAccountCode) {
    expect(this.resultingWallet.body.accountCode).to.eql(expectedAccountCode);
});