# my-wallet

El presente proyecto corresponde a un ejercicio para la aplicación de los distintos tipos de pruebas automatizadas para ser aplicadas sobre una aplicación que pretende modelar el funcionamiento de una billetera electrónica.

Este proyecto comprende de una aplicación web desarrollada en Java que consta de una REST API (el código es un proyecto desarrollado utilizando el IDE Netbeans 8.2 con servvidor Glashfish).

La mecionada REST API contiene los siguientes endpoints

Obtener una billetera 
GET http://localhost:8080/WalletApp/api/wallet/7644546

Acceder a la informacion de una billetera a travez de un accountCode y un PIN
POST http://localhost:8080/WalletApp/api/wallet/login

Agregar saldo a la billetera (saldo positivo o negativo)
POST http://localhost:8080/WalletApp/api/wallet/login

Transferir saldo entre billetera
POST http://localhost:8080/WalletApp/api/wallet/transfer


