/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.remote;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import remote.ServerRemoteInterface;

/**
 *
 * @author tbcabagay
 */
public class RemoteClientOperator {

    public RemoteClientOperator() {
        System.out.println("Connecting to remote server.");
        reLookUp();
    }

    private void reLookUp() {
        try {
            registry = LocateRegistry.getRegistry("127.0.0.1");
            serverRemoteInterface = (ServerRemoteInterface) registry.lookup("LibraryTracking");
        } catch (RemoteException | NotBoundException ex) {
            System.err.println("Error in " + RemoteClientOperator.class.getName() + ": " + ex.toString());
        }
    }

    private Registry registry;
    private ServerRemoteInterface serverRemoteInterface;

}
