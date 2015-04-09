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
public interface LibraryTrackingServerRemote extends Remote {

    String sayHello() throws RemoteException;

}
