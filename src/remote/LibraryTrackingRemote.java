/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author tbcabagay
 */
public abstract interface LibraryTrackingRemote extends Remote {

    public abstract boolean doLogin(String username, String password, String clientIP) throws RemoteException;
    
    public abstract boolean doLogout(String username, String clientIP) throws RemoteException;

}
