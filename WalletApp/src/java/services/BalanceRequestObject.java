/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.Serializable;

/**
 *
 * @author josec
 */
public class BalanceRequestObject implements Serializable{
    
    private String accountCode;
    private double balanceToAdd;

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public double getBalanceToAdd() {
        return balanceToAdd;
    }

    public void setBalanceToAdd(double balanceToAdd) {
        this.balanceToAdd = balanceToAdd;
    }
    
    
    
}
