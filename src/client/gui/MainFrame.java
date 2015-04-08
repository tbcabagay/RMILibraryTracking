/*
 * University Library, UP Los Banos
 * Computer Usage Tracking System
 */
package client.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

        initComponents();
    }

    private void initComponents() {
        loginPanel = new LoginPanel();

        add(loginPanel, BorderLayout.EAST);
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
    }

    private Dimension screenSize;
    private LoginPanel loginPanel;
}
