/*
 * University Library, UP Los Banos
 * Computer Usage Tracking System
 */
package client.gui;

import client.LibraryTrackingClient;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
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

        this.myDevice = LibraryTrackingClient.getMyDevice();

        initComponents();
    }

    private void initComponents() {
        loginPanel = new LoginPanel();

        add(loginPanel, BorderLayout.EAST);
    }

    private GraphicsDevice myDevice;
    private final Dimension screenSize;
    private LoginPanel loginPanel;

    @Override
    public void windowOpened(WindowEvent e) {
        myDevice.setFullScreenWindow(this);
        setExtendedState(WindowEvent.WINDOW_DEICONIFIED);
        setExtendedState(Frame.MAXIMIZED_BOTH);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        setVisible(true);
        addNotify();
        toFront();
        requestFocus();
        myDevice.setFullScreenWindow(this);
        setExtendedState(WindowEvent.WINDOW_DEICONIFIED);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
        setVisible(true);
        addNotify();
        toFront();
        requestFocus();
        myDevice.setFullScreenWindow(this);
        setExtendedState(WindowEvent.WINDOW_DEICONIFIED);
        setExtendedState(Frame.MAXIMIZED_BOTH);
    }

    @Override
    public void windowIconified(WindowEvent e) {
        setVisible(true);
        addNotify();
        toFront();
        requestFocus();
        myDevice.setFullScreenWindow(this);
        setExtendedState(WindowEvent.WINDOW_DEICONIFIED);
        setExtendedState(Frame.MAXIMIZED_BOTH);
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        setVisible(true);
        addNotify();
        toFront();
        requestFocus();
        myDevice.setFullScreenWindow(this);
        setExtendedState(WindowEvent.WINDOW_DEICONIFIED);
        setExtendedState(Frame.MAXIMIZED_BOTH);
    }

    @Override
    public void windowActivated(WindowEvent e) {
        addNotify();
        toFront();
        requestFocus();
        myDevice.setFullScreenWindow(this);
        setExtendedState(WindowEvent.WINDOW_DEICONIFIED);
        setExtendedState(Frame.MAXIMIZED_BOTH);
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        setVisible(true);
        addNotify();
        toFront();
        requestFocus();
        myDevice.setFullScreenWindow(this);
        setExtendedState(WindowEvent.WINDOW_DEICONIFIED);
        setExtendedState(Frame.MAXIMIZED_BOTH);
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
        setVisible(true);
        requestFocus();
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setExtendedState(WindowEvent.WINDOW_DEICONIFIED);
        myDevice.setFullScreenWindow(this);
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        setVisible(true);
        requestFocus();
        setExtendedState(WindowEvent.WINDOW_DEICONIFIED);
        setExtendedState(Frame.MAXIMIZED_BOTH);
    }
}
