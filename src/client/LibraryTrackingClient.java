package client;

import client.gui.MainFrame;
import client.gui.TimerFrame;
import client.remote.RemoteClientOperator;
import client.utilities.ClientConfigurationProps;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.SwingUtilities;

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

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                mainFrame = new MainFrame();
                timerFrame = new TimerFrame();
                myDevice.setFullScreenWindow(mainFrame);
            }
        });

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
        remoteClientOperator = new RemoteClientOperator();
    }

    public static void showTimerFrame(String name) {
        if(mainFrame.isVisible()) {
            
        } else {
            
        }
        
    }

    public static GraphicsDevice getMyDevice() {
        return myDevice;
    }

    public static void main(String[] args) {
        new LibraryTrackingClient();
    }

    private static GraphicsDevice myDevice;
    private static MainFrame mainFrame;
    private TimerFrame timerFrame;
    private RemoteClientOperator remoteClientOperator;
    private Properties properties;
    private FileInputStream fileInputStream;
}
