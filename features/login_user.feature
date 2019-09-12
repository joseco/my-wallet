Feature: Autenticar usuario
 Como Usuario Final (humano)
 Quiero autenticarme con mis datos para poder ver mi saldo

 Scenario: Se tiene datos validos y se muestran correctamente
  Given Dados datos de usuario accountCode: "7644546" y PIN: "5894"
   When Navego a la pagina de login 
     And Llenar el campo de Account Code
     And Llenar el campo de PIN
     And Hacer click en el boton Enter
     Then Se debe mostrar la cadena "7644546" en el valor Account Code
     And Debe haber un numero mayor o igual que 0 en el valor Balance