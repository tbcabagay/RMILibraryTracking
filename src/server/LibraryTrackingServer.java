/*
 * University Library, UP Los Banos
 * Computer Usage Tracking System
 */
package server;

import server.utilities.ServerConfigurationProps;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tbcabagay
 */
public class LibraryTrackingServer {

    public LibraryTrackingServer() {
        initConfig();
    }

    private void initConfig() {
        properties = new Properties();
        System.out.println("Reading server configuration.");

        try {
            fileInputStream = new FileInputStream((new StringBuilder()).append("config").append(File.separator).append("server").append(File.separator).append("server.configuration.props").toString());
        } catch (FileNotFoundException ex) {
            System.err.println("Error in " + LibraryTrackingServer.class.getName() + ": " + ex.toString());
            System.exit(1);
        }

        serverConfigurationProps = new ServerConfigurationProps(properties);

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
}
