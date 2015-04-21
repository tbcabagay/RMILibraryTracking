/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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

    public void setTimerText(String s) {
        timerField.setText(s);
        timerField.repaint();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private JTextField timerField;
    private JButton logoutButton;
    private String studentID;
}
