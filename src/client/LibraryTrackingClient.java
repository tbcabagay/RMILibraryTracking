package client;

import client.gui.MainFrame;
import client.remote.RemoteClientOperator;
import client.utilities.ClientConfigurationProps;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/*
 * University Library, UP Los Banos
 * Computer Usage Tracking System
 */
/**
 *
 * @author tbcabagay
 */
public class LibraryTrackingClient {

    public LibraryTrackingClient() {
        GraphicsEnvironment myEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        myDevice = myEnvironment.getDefaultScreenDevice();

        mainFrame = new MainFrame();

        try {
            myDevice.setFullScreenWindow(mainFrame);
        } finally {
            myDevice.setFullScreenWindow(null);
        }

        initConfig();
    }

    private void initConfig() {
        properties = new Properties();
        System.out.println("Reading client configuration.");

        try {
            fileInputStream = new FileInputStream((new StringBuilder()).append("config").append(File.separator).append("client").append(File.separator).append("client.configuration.props").toString());
            properties.load(fileInputStream);
        } catch (Exception ex) {
            System.err.println("Error in " + LibraryTrackingClient.class.getName() + ": " + ex.toString());
            System.exit(1);
        }

        ClientConfigurationProps clientConfigurationProps = new ClientConfigurationProps(properties);
        
        System.out.println("Initializing remote connection.");
        RemoteClientOperator remoteClientOperator = new RemoteClientOperator();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibraryTrackingClient();
            }
        });
    }

    private final GraphicsDevice myDevice;
    private final MainFrame mainFrame;
    private Properties properties;
    private FileInputStream fileInputStream;
}
