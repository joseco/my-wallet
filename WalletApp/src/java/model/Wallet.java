/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author josec
 */
public class Wallet {
    
    private String acountCode;
    private String ownerName;
    private String pin;
    private double balance;

    public Wallet() {
    }

    public Wallet(String acountCode, String ownerName, String pin, double balance) {
        this.acountCode = acountCode;
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

    public String getAcountCode() {
        return acountCode;
    }

    public void setAcountCode(String acountCode) {
        this.acountCode = acountCode;
    }
    
    
    
}
