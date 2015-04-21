/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 *
 * @author tbcabagay
 */
public class PasswordChangePanel extends JPanel {

    public PasswordChangePanel() {
        initComponents();
    }

    private void initComponents() {
        passwordLabel = new JLabel("New password:");
        passwordField = new JPasswordField(20);
        changeButton = new JButton("Change");

        JPanel container = new JPanel();
        container.add(passwordLabel);
        container.add(passwordField);
        add(container);
        add(changeButton);
    }

    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton changeButton;
}
