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
public class LibraryTrackingClient implements Runnable {

    public LibraryTrackingClient() {
        GraphicsEnvironment myEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        LibraryTrackingClient.myDevice = myEnvironment.getDefaultScreenDevice();

        initConfig();
        initRemoteConnection();
    }

    @Override
    public void run() {
        LibraryTrackingClient.mainFrame = new MainFrame();
        LibraryTrackingClient.timerFrame = new TimerFrame();

        try {
            LibraryTrackingClient.myDevice.setFullScreenWindow(LibraryTrackingClient.mainFrame);
        } catch (Exception ex) {
            System.err.println("Error in " + LibraryTrackingClient.class.getName() + ": " + ex.toString());
        }
    }

    private void initConfig() {
        System.out.println("Reading client configuration.");

        Properties properties = new Properties();

        try {
            FileInputStream fileInputStream = new FileInputStream((new StringBuilder()).append("config").append(File.separator).append("client").append(File.separator).append("client.configuration.props").toString());
            properties.load(fileInputStream);
        } catch (Exception ex) {
            System.err.println("Error in " + LibraryTrackingClient.class.getName() + ": " + ex.toString());
            System.exit(1);
        }

        LibraryTrackingClient.clientConfigurationProps = new ClientConfigurationProps(properties);
    }

    private void initRemoteConnection() {
        System.out.println("Initializing remote connection.");
        LibraryTrackingClient.remoteClientOperator = new RemoteClientOperator();
    }

    public static void showTimerFrame(String student) {
        if (LibraryTrackingClient.timerFrame.isVisible()) {
            LibraryTrackingClient.timerFrame.setFrameRegisterID(false);
            LibraryTrackingClient.timerFrame.resetAllFields();
            LibraryTrackingClient.timerFrame.setVisible(false);
        }
        LibraryTrackingClient.mainFrame.setMadBehaviour(false);
        LibraryTrackingClient.timerFrame.setStudentNumber(student);
        LibraryTrackingClient.timerFrame.setAlertMinutes(3);
        LibraryTrackingClient.timerFrame.startMinuteCounter();
        LibraryTrackingClient.timerFrame.pack();
        LibraryTrackingClient.timerFrame.setFrameRegisterID(true);
        LibraryTrackingClient.timerFrame.setVisible(true);
    }

    public static GraphicsDevice getMyDevice() {
        return LibraryTrackingClient.myDevice;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new LibraryTrackingClient());
    }

    private static GraphicsDevice myDevice;
    private static MainFrame mainFrame;
    private static TimerFrame timerFrame;
    private static ClientConfigurationProps clientConfigurationProps;
    private static RemoteClientOperator remoteClientOperator;
}
