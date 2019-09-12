const { Given, When, Then } = require('cucumber')
const { expect } = require('chai')
const httpClient = require('request-promise')

Given('El codigo de cuenta de billetera {string} y el monto {int}', function (accountCode, amountToAdd) {
    this.setupInformationToAddBalance(accountCode, amountToAdd);
});


When('Hago la peticion HTTP POST al endpoint de consulta', async function () {
    await this.requestBalanceAddition(httpClient);
});


Then('Obtengo una respuesta http status {int}', function (expectedStatusCode) {
    expect(this.resultingBalanceAdditionRequest.statusCode).to.eql(expectedStatusCode);
});