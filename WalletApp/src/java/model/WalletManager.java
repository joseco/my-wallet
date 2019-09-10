/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;

/**
 *
 * @author josec
 */
public class WalletManager {
    
    private HashMap<String, Wallet> wallets;
    
    private static WalletManager instance;
    
    private WalletManager(){
        this.wallets = new HashMap<>();
        
        this.wallets.put("7644546", new Wallet("7644546", "Jhon Smith", "5894", 152));
        this.wallets.put("7845245", new Wallet("7845245", "Martha Loaiza", "39752", 10));
        this.wallets.put("7932145", new Wallet("7932145", "Teresa Mendez", "2597", 0));
        this.wallets.put("7452130", new Wallet("7452130", "Juan Perez", "1985", 500));        
    }
    
    public static WalletManager getManager(){
        if(instance == null)
            instance = new WalletManager();
        return instance;
    }

    public Wallet getWalletFromAccountCode(String accountNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
