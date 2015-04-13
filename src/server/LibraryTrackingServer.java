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
import server.database.DatabaseConnection;

/**
 *
 * @author tbcabagay
 */
public class LibraryTrackingServer {

    public LibraryTrackingServer() {
        initConfig();
        initDatabaseConnection();
        initRemoteConnection();
    }

    private void initConfig() {
        properties = new Properties();

        try {
            System.out.print("Reading server configuration...");
            fileInputStream = new FileInputStream((new StringBuilder()).append("config").append(File.separator).append("server").append(File.separator).append("server.configuration.props").toString());
            properties.load(fileInputStream);
            System.out.println(" done.");
        } catch (Exception ex) {
            System.err.println("Error in " + LibraryTrackingServer.class.getName() + ": " + ex.toString());
            System.exit(1);
        }

        serverConfigurationProps = new ServerConfigurationProps(properties);
    }

    private void initDatabaseConnection() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
    }

    private void initRemoteConnection() {
        if (System.getSecurityManager() == null) {
            System.out.print("Loading security manager... ");
            System.setSecurityManager(new SecurityManager());
            System.out.println(" done.");
        }

        try {
            System.out.print("Starting remote server...");
            serverManager = new ServerManager();
            LibraryTrackingServerRemote stub = (LibraryTrackingServerRemote) UnicastRemoteObject.exportObject(serverManager, 9898);

            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(ServerConfigurationProps.REMOTE_OBJECT_NAME, stub);
            System.out.println(" done.");
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
