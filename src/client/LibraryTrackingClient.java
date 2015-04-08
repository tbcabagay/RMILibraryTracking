package client;


import client.gui.MainFrame;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

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
}
