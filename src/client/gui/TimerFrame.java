/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author tbcabagay
 */
public class TimerFrame extends JFrame implements ActionListener, WindowListener, WindowFocusListener {

    public TimerFrame() {
        this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        this.minutes = 0;
        this.hours = 0;
        this.timerCounter = new Timer(60000, this);

        initComponents();
    }

    private void initComponents() {
        setLocation((int) (screenSize.getWidth() / 2D - 50D), 0);
        setResizable(false);

        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());

        timerDisplayPanel = new TimerDisplayPanel();
        passwordChangePanel = new PasswordChangePanel();

        timerDisplayPanel.setTimerText((new StringBuilder()).append(hours).append(":").append(minutes).toString());
        setTitle((new StringBuilder()).append("Time> ").append(hours).append(":").append(minutes).toString());
        this.alertDialog = new AlertDialog(this);

        container.add(timerDisplayPanel);

        getContentPane().add(container);
        pack();
    }

    public static void autoLogoff() {
        /*String s = RemoteClientOperator.requestLogout(userId);
        if (s.equals("true")) {
            ClientOpMain.setSessionMsg((new StringBuilder()).append("Last Session Duration:").append(getTimeDuration()).toString());
            ClientOpMain.showEntryWindow();
        } else {
            ClientOpMain.setSessionMsg((new StringBuilder()).append("Last Session Duration: ").append(getTimeDuration()).append("Error:").append(s).toString());
            ClientOpMain.showEntryWindow();
        }*/
    }

    public void setRegid(boolean flag) {
        if (flag) {
            addWindowListener(this);
            addWindowFocusListener(this);
        } else {
            removeWindowListener(this);
            removeWindowFocusListener(this);
        }
    }

    public void resetAllFields() {
        minutes = 0;
        hours = 0;
        //timerDisplay.setTimerText("");
        userId = "";
        setTitle((new StringBuilder()).append("Time> ").append(hours).append(":").append(minutes).toString());
        //alertDialog.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static String userId;
    private int minutes;
    private int hours;
    private int alertMins;
    private final Timer timerCounter;
    private final Dimension screenSize;
    private TimerDisplayPanel timerDisplayPanel;
    private PasswordChangePanel passwordChangePanel;
    private AlertDialog alertDialog;
}
