/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author josec
 */
public class Wallet implements Serializable{
    
    private String accountCode;
    private String ownerName;
    private String pin;
    public Double balance;

    public Wallet() {
    }

    public Wallet(String accountCode, String ownerName, String pin, double balance) {
        this.accountCode = accountCode;
        this.ownerName = ownerName;
        this.pin = pin;
        this.balance = balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public void addBalance(double balanceToAdd) {
        if(this.balance + balanceToAdd < 0)
            throw new IllegalArgumentException("El monto a añadir no puede dejar el balance en un valor menor a cero");
        this.balance += balanceToAdd;
    }
    
    
    
}
