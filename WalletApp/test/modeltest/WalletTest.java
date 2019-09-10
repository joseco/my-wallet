package modeltest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import model.Wallet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author josec
 */
public class WalletTest {

    @Test
    public void addWalletPositiveBalance() {

        Wallet wallet = new Wallet("123466","Jhon Smith", "5555", 50);
        wallet.addBalance(500);

        double expected = 550;
        double actual = wallet.getBalance();
        double delta = 0;
        
        assertEquals(expected, actual, delta);
        
    }
    
    @Test
    public void addWalletNegativeBalance(){
        
        Wallet wallet = new Wallet("123466","Jhon Smith", "5555", 50);
        wallet.addBalance(-30);

        double expected = 20;
        double actual = wallet.getBalance();
        double delta = 0;
        
        assertEquals(expected, actual, delta);
         
        
    }
}
