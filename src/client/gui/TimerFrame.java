/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui;

import client.LibraryTrackingClient;
import client.remote.RemoteClientOperator;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author tbcabagay
 */
public class TimerFrame extends JFrame implements ActionListener, WindowListener, WindowFocusListener {

    public TimerFrame() {
        this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        TimerFrame.minutes = 0;
        TimerFrame.hours = 0;
        this.timerCounter = new Timer(60000, this);

        TimerFrame.student = "";

        initComponents();
    }

    private void initComponents() {
        setLocation((int) (screenSize.getWidth() / 2D - 50D), 0);
        setResizable(false);

        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());

        Border border = BorderFactory.createEtchedBorder();
        titledBorder = BorderFactory.createTitledBorder(border);
        container.setBorder(titledBorder);

        timerDisplayPanel = new TimerDisplayPanel();
        passwordChangePanel = new PasswordChangePanel();

        timerDisplayPanel.setTimerText((new StringBuilder()).append(TimerFrame.hours).append(":").append(TimerFrame.minutes).toString());
        setTitle((new StringBuilder()).append("Time> ").append(TimerFrame.hours).append(":").append(TimerFrame.minutes).toString());
        alertDialog = new AlertDialog(this);

        container.add(timerDisplayPanel);

        getContentPane().add(container);
    }

    public static void autoLogoff() {
        String response = RemoteClientOperator.requestLogout(TimerFrame.student);
        if (response.equals("true")) {
            LibraryTrackingClient.setSessionMessage((new StringBuilder()).append("Last Session Duration: ").append(getTimeDuration()).toString());
        } else {
            LibraryTrackingClient.setSessionMessage((new StringBuilder()).append("Last Session Duration: ").append(getTimeDuration()).append("Error: ").append(response).toString());
        }
        LibraryTrackingClient.showEntryWindow();
    }

    public void startMinuteCounter() {
        timerCounter.start();
        titledBorder.setTitle(TimerFrame.student);
    }

    public void stopMinuteCounter() {
        timerCounter.stop();
        TimerFrame.minutes = 0;
        TimerFrame.hours = 0;
        timerDisplayPanel.setTimerText((new StringBuilder()).append(TimerFrame.hours).append(":").append(TimerFrame.minutes).toString());
        titledBorder.setTitle("");
    }

    public void setFrameRegisterID(boolean flag) {
        if (flag) {
            addWindowListener(this);
            addWindowFocusListener(this);
        } else {
            removeWindowListener(this);
            removeWindowFocusListener(this);
        }
    }

    public void resetAllFields() {
        TimerFrame.minutes = 0;
        TimerFrame.hours = 0;
        timerDisplayPanel.setTimerText("");
        TimerFrame.student = "";
        setTitle((new StringBuilder()).append("Time> ").append(TimerFrame.hours).append(":").append(TimerFrame.minutes).toString());
        alertDialog.setVisible(false);
    }

    public String getStudentNumber() {
        return TimerFrame.student;
    }

    public void setStudentNumber(String student) {
        TimerFrame.student = student;
        timerDisplayPanel.setStudentNumber(TimerFrame.student);
    }

    public int getMinutes() {
        return TimerFrame.minutes;
    }

    public void setMinutes(int minutes) {
        TimerFrame.minutes = minutes;
    }

    public int getHours() {
        return TimerFrame.hours;
    }

    public void setHours(int hours) {
        TimerFrame.hours = hours;
    }

    public int getAlertMinutes() {
        return alertMinutes;
    }

    public void setAlertMinutes(int alertMinutes) {
        this.alertMinutes = alertMinutes;
    }

    public static String getTimeDuration() {
        return (new StringBuilder()).append(TimerFrame.hours).append(":").append(TimerFrame.minutes).toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TimerFrame.minutes++;
        if (TimerFrame.minutes >= 60) {
            TimerFrame.minutes = 0;
            TimerFrame.hours++;
        }
        timerDisplayPanel.setTimerText((new StringBuilder()).append(TimerFrame.hours).append(":").append(TimerFrame.minutes).toString());
        if (TimerFrame.minutes >= alertMinutes - 1) {
            double d = TimerFrame.minutes % (alertMinutes - 1);
            if (d == 0.0D) {
                System.out.println("d: " + d + " TimerFrame.minutes: " + TimerFrame.minutes + " alertMinutes: " + alertMinutes);
                GraphicsDevice graphicsDevice = LibraryTrackingClient.getMyDevice();
                alertDialog.setMessage((new StringBuilder()).append("1 minute to").append(" ").append(TimerFrame.hours).append(":").append(TimerFrame.minutes + 1).toString());

                try {
                    graphicsDevice.setFullScreenWindow(alertDialog);
                } finally {
                    graphicsDevice.setFullScreenWindow(null);
                }
            }
        }
        setTitle((new StringBuilder()).append("Time> ").append(TimerFrame.hours).append(":").append(TimerFrame.minutes).toString());
    }

    @Override
    public void windowOpened(WindowEvent e) {
        if (!isVisible()) {
            setVisible(true);
            requestFocusInWindow();
        }
        setExtendedState(WindowEvent.WINDOW_DEICONIFIED);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        setVisible(true);
        requestFocusInWindow();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        setVisible(true);
        requestFocusInWindow();
        setExtendedState(Frame.NORMAL);
    }

    @Override
    public void windowIconified(WindowEvent e) {
        setVisible(true);
        setExtendedState(Frame.NORMAL);
        addNotify();
        requestFocusInWindow();
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        setExtendedState(Frame.NORMAL);
        addNotify();
        requestFocus();
    }

    @Override
    public void windowActivated(WindowEvent e) {
        setVisible(true);
        setExtendedState(WindowEvent.WINDOW_DEICONIFIED);
        requestFocus();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        if (!isVisible()) {
            setVisible(true);
            requestFocus();
        }
        setExtendedState(Frame.NORMAL);
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
        if (!isVisible()) {
            setVisible(true);
            setExtendedState(WindowEvent.WINDOW_DEICONIFIED);
        }
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        if (!isVisible()) {
            setVisible(true);
        }
        setExtendedState(Frame.NORMAL);
    }

    private static String student;
    private static int minutes;
    private static int hours;
    private int alertMinutes;
    private final Timer timerCounter;
    private final Dimension screenSize;
    private TimerDisplayPanel timerDisplayPanel;
    private PasswordChangePanel passwordChangePanel;
    private AlertDialog alertDialog;
    private TitledBorder titledBorder;
}
