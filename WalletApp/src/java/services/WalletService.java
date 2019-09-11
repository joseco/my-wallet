/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Wallet;
import model.WalletManager;

/**
 *
 * @author josec
 */
@Path("wallet")
public class WalletService {
    
    @GET
    @Path("/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWallet(@PathParam("code") String accountCode){
        Wallet obj = WalletManager.getManager().getWalletFromAccountCode(accountCode);
        if(obj == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        
        return Response.ok(obj).build();
    }
    
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(LoginRequestObject obj){
        Wallet wallet = WalletManager.getManager().getWalletFromAccountCode(obj.getAccountCode());
        if(wallet == null || !wallet.getPin().equals(obj.getPin()))
            return Response.status(Response.Status.NOT_FOUND).build();
        
        return Response.ok(obj).build();
    }
    
    @POST
    @Path("/add-balance")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addWalletBalance(BalanceRequestObject requestObject){
        Wallet obj = WalletManager.getManager().getWalletFromAccountCode(requestObject.getAccountCode());
        try {
            obj.addBalance(requestObject.getBalanceToAdd());
        } catch (IllegalArgumentException e) {
            return Response.status(400).build();
        }catch(Exception e){
            return Response.serverError().build();
        }
        
        return Response.ok().build();
    }
    
    @Path("/transfer")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response transferBetweenWallet(TransferRequestObject param){
        try {
           WalletManager manager = WalletManager.getManager();
           manager.trasnferBalanceBetweenWallets(param.getOriginAccountCode(), 
                   param.getTargetAccountCode(), param.getAmount());
            
        } catch (IllegalArgumentException e) {
            return Response.status(400).build();
        }catch(Exception e){
            return Response.serverError().build();
        }        
        return Response.ok().build();
    }
    
}
