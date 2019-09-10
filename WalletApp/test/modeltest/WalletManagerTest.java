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
    
    @Test
    public void shouldGetNullWalletFromNonExistentAccountCode(){
        WalletManager manager = WalletManager.getManager();
        String expectedAccountCode = "XXXXXXXX";
        Wallet wallet = manager.getWalletFromAccountCode(expectedAccountCode);
        
        assertNull(wallet);
    }
    
    @Test
    public void shouldTransferBalaceBetweenWallets(){
        WalletManager manager = WalletManager.getManager();
        
        double amountToTransfer = 50;
        
        String originAccountCode = "7644546";
        Wallet originWallet = manager.getWalletFromAccountCode(originAccountCode);
        double originInitialBalance = originWallet.getBalance();        
        
        String destinationAccountCode = "7452130";
        Wallet destinationWallet = manager.getWalletFromAccountCode(destinationAccountCode);
        double destinationInitialBalance = destinationWallet.getBalance();
        
        double expectedOriginBalace = originInitialBalance - amountToTransfer;
        double expectedDestinationBalace = destinationInitialBalance + amountToTransfer;
        
        manager.trasnferBalanceBetweenWallets(originAccountCode, destinationAccountCode, amountToTransfer);
        
        double actualOriginBalance = originWallet.getBalance();
        double actualDestinationBalance = destinationWallet.getBalance();
        
        double delta = 0.0;
        
        assertEquals(expectedOriginBalace, actualOriginBalance, delta);
        assertEquals(expectedDestinationBalace, actualDestinationBalance, delta);
        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shouldNotTransferBalaceBetweenWallets(){
        WalletManager manager = WalletManager.getManager();
        
        double amountToTransfer = 300;
        
        String originAccountCode = "7644546";
        Wallet originWallet = manager.getWalletFromAccountCode(originAccountCode);
        double originInitialBalance = originWallet.getBalance();        
        
        String destinationAccountCode = "7452130";
        Wallet destinationWallet = manager.getWalletFromAccountCode(destinationAccountCode);
        double destinationInitialBalance = destinationWallet.getBalance();
        
        double expectedOriginBalace = originInitialBalance;
        double expectedDestinationBalace = destinationInitialBalance;
        
        manager.trasnferBalanceBetweenWallets(originAccountCode, destinationAccountCode, amountToTransfer);
        
        double actualOriginBalance = originWallet.getBalance();
        double actualDestinationBalance = destinationWallet.getBalance();
        
        double delta = 0.0;
        
        assertEquals(expectedOriginBalace, actualOriginBalance, delta);
        assertEquals(expectedDestinationBalace, actualDestinationBalance, delta);
        
    }
    
}
