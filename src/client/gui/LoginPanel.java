/*
 * University Library, UP Los Banos
 * Computer Usage Tracking System
 */
package client.gui;

import client.LibraryTrackingClient;
import client.remote.RemoteClientOperator;
import client.utilities.UIGenHelper;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import client.utilities.Messages;
import java.awt.Color;

/**
 *
 * @author tbcabagay
 */
public class LoginPanel extends JPanel implements ActionListener {

    public LoginPanel() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());

        errorLabel = new JLabel("");
        errorLabel.setForeground(Color.red);

        studentLabel = new JLabel("Student ID");
        passwordLabel = new JLabel("Password");
        studentField = new JTextField(10);
        passwordField = new JPasswordField();
        loginButton = new JButton("Enter");

        UIGenHelper.addToGrid(this, errorLabel, 0, 0, 2, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE);
        UIGenHelper.addToGrid(this, studentLabel, 0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE);
        UIGenHelper.addToGrid(this, studentField, 1, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH);
        UIGenHelper.addToGrid(this, passwordLabel, 0, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE);
        UIGenHelper.addToGrid(this, passwordField, 1, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH);
        UIGenHelper.addToGrid(this, loginButton, 0, 3, 2, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE);
        UIGenHelper.applyBorder(this, "Login");

        studentField.addActionListener(this);
        passwordField.addActionListener(this);
        loginButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String student = studentField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        if (validateForm(student, password)) {
            boolean response = RemoteClientOperator.requestLogin(student, password);
            if (response) {
                errorLabel.setText("");
                studentField.setText("");
                passwordField.setText("");
                LibraryTrackingClient.showTimerFrame(student);
            } else {
                errorLabel.setText(message.getMessage("login_error"));
                errorLabel.repaint();
            }
        }
    }

    private boolean validateForm(String student, String password) {
        boolean containsError = false;
        message = new Messages();

        if (student.equals("") && password.equals("")) {
            containsError = true;
            errorLabel.setText(message.getMessage("studentpasswordfield_error"));
            errorLabel.repaint();
        } else if (student.equals("")) {
            containsError = true;
            errorLabel.setText(message.getMessage("studentfield_error"));
            errorLabel.repaint();
        } else if (password.equals("")) {
            containsError = true;
            errorLabel.setText(message.getMessage("passwordfield_error"));
            errorLabel.repaint();
        }

        if (containsError) {
            return false;
        }
        return true;
    }

    public void setErrorLabel(String message) {
        errorLabel.setText(message);
        errorLabel.repaint();
    }

    /*public int getAlertMinutes() {
     int i = ClientConfig.DEFAULT_LOGOFF;
     try {
     i = Integer.parseInt((String) alertTextCombo.getSelectedItem());
     } catch (Exception exception) {
     System.out.println((new StringBuilder()).append("Error: LoginPanel.getAlertMinutes(). ").append(exception).toString());
     }
     return i;
     }*/
    private JLabel errorLabel;
    private JLabel studentLabel;
    private JLabel passwordLabel;
    private JTextField studentField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private Messages message;
}
