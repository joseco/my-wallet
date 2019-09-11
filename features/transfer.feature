Feature: Adicion de Saldo a Billetera

    Como cliente Web (no humano), deseo agregar el saldo de una billetera a partir de su codigo de cuenta y el monto a agregar
   
    Scenario: Adicion de Saldo positivo

        Given El codigo de cuenta de billetera "7644546" y el monto "65"
        When Hago la peticion HTTP POST al endpoint de consulta
        Then Obtengo una respuesta http status 200 
