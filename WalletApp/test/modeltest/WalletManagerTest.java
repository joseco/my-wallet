/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeltest;

import model.Wallet;
import model.WalletManager;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author josec
 */
public class WalletManagerTest {

    @Test
    public void shouldGetWalletFromAccountCode(){
        WalletManager manager = WalletManager.getManager();
        String expectedAccountCode = "7644546";
        Wallet wallet = manager.getWalletFromAccountCode(expectedAccountCode);
        
        assertNotNull(wallet);
        String actualAccountNumber = wallet.getAcountCode();
        
        assertEquals(expectedAccountCode, actualAccountNumber);
    }
    
}
