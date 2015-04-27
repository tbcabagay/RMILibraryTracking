/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author tbcabagay
 */
public class TimerDisplayPanel extends JPanel implements ActionListener {

    public TimerDisplayPanel() {
        initComponents();
    }

    private void initComponents() {
        timerField = new JTextField(5);
        timerField.setEditable(false);

        logoutButton = new JButton("Logout");
        logoutButton.addActionListener(this);

        add(timerField);
        add(logoutButton);
    }

    public void setTimerText(String time) {
        timerField.setText(time);
        timerField.repaint();
        repaint();
    }

    public void setStudentNumber(String student) {
        this.student = student;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i = JOptionPane.showConfirmDialog(this, "Are You Sure?", "Log Out!!", 2, 2);
        if (i == 0) {
            /*TimerDisplayPanel _tmp = this;
            String response = RemoteClientOperator.requestLogout(studentNumber);
            if (response.equals("true")) {
                LibraryTrackingClient.setSessionMsg((new StringBuilder()).append("Last Session Duration:").append(TimerFrame.getTimeDuration()).toString());
                LibraryTrackingClient.showEntryWindow();
            } else {
                LibraryTrackingClient.setSessionMsg((new StringBuilder()).append("Last Session Duration: ").append(TimerFrame.getTimeDuration()).append("Error:").append(response).toString());
                LibraryTrackingClient.showEntryWindow();
            }*/
        }
    }

    private JTextField timerField;
    private JButton logoutButton;
    private String student;
}
