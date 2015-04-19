/*
 * University Library, UP Los Banos
 * Computer Usage Tracking System
 */
package client.gui;

import client.LibraryTrackingClient;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

/**
 *
 * @author tbcabagay
 */
public class MainFrame extends JFrame implements WindowListener, WindowFocusListener {

    public MainFrame() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setLayout(new BorderLayout());
        setTitle("Computer Usage Tracking System");
        setUndecorated(true);
        setSize(new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight()));

        addWindowFocusListener(this);
        addWindowListener(this);

        myDevice = LibraryTrackingClient.getMyDevice();

        initComponents();
    }

    private void initComponents() {
        loginPanel = new LoginPanel();

        add(loginPanel, BorderLayout.EAST);
    }

    public void windowGainedFocus(WindowEvent windowevent) {
        setVisible(true);
        requestFocus();
        setExtendedState(6);
        setExtendedState(204);
        myDevice.setFullScreenWindow(this);
    }

    public void windowLostFocus(WindowEvent windowevent) {
        setVisible(true);
        requestFocus();
        setExtendedState(204);
        setExtendedState(6);
        myDevice.setFullScreenWindow(this);
    }

    public void windowActivated(WindowEvent windowevent) {
        addNotify();
        toFront();
        requestFocus();
        myDevice.setFullScreenWindow(this);
        setExtendedState(204);
        setExtendedState(6);
    }

    public void windowClosed(WindowEvent windowevent) {
        setVisible(true);
        addNotify();
        toFront();
        requestFocus();
        myDevice.setFullScreenWindow(this);
        setExtendedState(204);
        setExtendedState(6);
    }

    public void windowClosing(WindowEvent windowevent) {
        setVisible(true);
        addNotify();
        toFront();
        requestFocus();
        myDevice.setFullScreenWindow(this);
        setExtendedState(204);
        setExtendedState(6);
    }

    public void windowDeactivated(WindowEvent windowevent) {
        setVisible(true);
        addNotify();
        toFront();
        requestFocus();
        myDevice.setFullScreenWindow(this);
        setExtendedState(204);
        setExtendedState(6);
    }

    public void windowDeiconified(WindowEvent windowevent) {
        setVisible(true);
        addNotify();
        toFront();
        requestFocus();
        myDevice.setFullScreenWindow(this);
        setExtendedState(204);
        setExtendedState(6);
    }

    public void windowIconified(WindowEvent windowevent) {
        setVisible(true);
        addNotify();
        toFront();
        requestFocus();
        myDevice.setFullScreenWindow(this);
        setExtendedState(204);
        setExtendedState(6);
    }

    public void windowOpened(WindowEvent windowevent) {
        myDevice.setFullScreenWindow(this);
        setExtendedState(204);
        setExtendedState(6);
    }

    private GraphicsDevice myDevice;
    private final Dimension screenSize;
    private LoginPanel loginPanel;
}
