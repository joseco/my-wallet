Feature: Obtencion de Saldo de Billetera

    Como cliente Web (no humano), deseo obtener el saldo de una billetera a partir de su codigo de cuenta
   
    Scenario: Obtencion de Saldo de una cuenta existente

        Given El codigo de cuenta de billetera "7644546"
        When Hago la peticion HTTP al endpoint de consulta
        Then Obtengo una respuesta http status 200 junto con el JSON de Respuesta
        Then Comparo que el accountCode obtenido sea "7644546"

