/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.remote;

import client.utilities.ClientConfigurationProps;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Collections;
import java.util.List;
import org.apache.commons.validator.routines.InetAddressValidator;
import remote.LibraryTrackingRemote;

/**
 *
 * @author tbcabagay
 */
public class RemoteClientOperator {

    public RemoteClientOperator() {
        System.out.println("Connecting to remote server.");
        reLookUp();
        registerClientIP();
    }

    public static boolean requestLogin(String username, String password) {
        boolean result = false;
        try {
            if (RemoteClientOperator.stub.doLogin(username, password, RemoteClientOperator.clientIP)) {
                result = true;
            }
        } catch (Exception ex) {
            System.err.println("Error in " + RemoteClientOperator.class.getName() + ": " + ex.toString());
        }
        return result;
    }

    public static String requestLogout(String student) {
        String result = "false";
        try {
            result = "true";
        } catch (Exception ex) {
            System.err.println("Error in " + RemoteClientOperator.class.getName() + ": " + ex.toString());
        }
        return result;
    }

    private void reLookUp() {
        try {
            RemoteClientOperator.registry = LocateRegistry.getRegistry(ClientConfigurationProps.SERVER_NAME, ClientConfigurationProps.SERVER_PORT);
            RemoteClientOperator.stub = (LibraryTrackingRemote) RemoteClientOperator.registry.lookup(ClientConfigurationProps.REMOTE_OBJECT_NAME);
        } catch (Exception ex) {
            System.err.println("Error in asd" + RemoteClientOperator.class.getName() + ": " + ex.toString());
        }
    }

    private void registerClientIP() {
        try {
            List<NetworkInterface> interfaces;
            interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());

            for (NetworkInterface iface : interfaces) {
                List<InetAddress> addresses = Collections.list(iface.getInetAddresses());
                for (InetAddress address : addresses) {
                    if (!address.isLoopbackAddress()) {
                        String hostAddress = address.getHostAddress().toUpperCase();
                        if (InetAddressValidator.getInstance().isValidInet4Address(hostAddress)) {
                            RemoteClientOperator.clientIP = hostAddress;
                        }

                    }
                }

            }
        } catch (Exception ex) {
            System.err.println("Error in asd" + RemoteClientOperator.class.getName() + ": " + ex.toString());
        }
    }

    private static String clientIP;
    private static Registry registry;
    private static LibraryTrackingRemote stub;

}
