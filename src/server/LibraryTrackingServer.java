/*
 * University Library, UP Los Banos
 * Computer Usage Tracking System
 */
package server;

import remote.LibraryTrackingServerRemote;
import server.remote.ServerManager;
import server.utilities.ServerConfigurationProps;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Properties;

/**
 *
 * @author tbcabagay
 */
public class LibraryTrackingServer {

    public LibraryTrackingServer() {
        initConfig();
        initRemoteConnection();
    }

    private void initConfig() {
        properties = new Properties();
        System.out.println("Reading server configuration.");

        try {
            fileInputStream = new FileInputStream((new StringBuilder()).append("config").append(File.separator).append("server").append(File.separator).append("server.configuration.props").toString());
            properties.load(fileInputStream);
        } catch (Exception ex) {
            System.err.println("Error in " + LibraryTrackingServer.class.getName() + ": " + ex.toString());
            System.exit(1);
        }

        serverConfigurationProps = new ServerConfigurationProps(properties);
    }

    private void initRemoteConnection() {
        try {
            serverManager = new ServerManager();
            LibraryTrackingServerRemote stub = (LibraryTrackingServerRemote) UnicastRemoteObject.exportObject(serverManager, 0);

            Registry registry = LocateRegistry.getRegistry();
            registry.bind("LibraryTracking", stub);

            System.out.println("Remote server ready.");
        } catch (Exception ex) {
            System.err.println("Error in " + LibraryTrackingServer.class.getName() + ": " + ex.toString());
        }

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new LibraryTrackingServer();
            }

        });
    }

    private Properties properties;
    private FileInputStream fileInputStream;
    private static ServerConfigurationProps serverConfigurationProps;
    private ServerManager serverManager;
}
