/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.remote;

import client.utilities.ClientConfigurationProps;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import remote.LibraryTrackingServerRemote;

/**
 *
 * @author tbcabagay
 */
public class RemoteClientOperator {

    public RemoteClientOperator() {
        System.out.println("Connecting to remote server.");
        reLookUp();
    }

    public 
    
    private void reLookUp() {
        try {
            registry = LocateRegistry.getRegistry(ClientConfigurationProps.SERVER_NAME, Integer.parseInt(ClientConfigurationProps.SERVER_PORT));
            stub = (LibraryTrackingServerRemote) registry.lookup(ClientConfigurationProps.REMOTE_OBJECT_NAME);
        } catch (Exception ex) {
            System.err.println("Error in " + RemoteClientOperator.class.getName() + ": " + ex.toString());
        }
    }

    private Registry registry;
    private LibraryTrackingServerRemote stub;

}
