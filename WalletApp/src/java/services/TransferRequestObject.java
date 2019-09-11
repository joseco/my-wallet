/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author josec
 */
public class TransferRequestObject {
    
    private String originAccountCode;
    private String targetAccountCode;
    public double amount;

    public String getOriginAccountCode() {
        return originAccountCode;
    }

    public void setOriginAccountCode(String originAccountCode) {
        this.originAccountCode = originAccountCode;
    }

    public String getTargetAccountCode() {
        return targetAccountCode;
    }

    public void setTargetAccountCode(String targetAccountCode) {
        this.targetAccountCode = targetAccountCode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
    
}
