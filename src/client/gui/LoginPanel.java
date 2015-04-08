/*
 * University Library, UP Los Banos
 * Computer Usage Tracking System
 */
package client.gui;

import client.utilities.UIGenHelper;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import client.utilities.Messages;

/**
 *
 * @author tbcabagay
 */
public class LoginPanel extends JPanel implements ActionListener {

    public LoginPanel() {
        setLayout(new GridBagLayout());
        initComponents();
    }

    private void initComponents() {
        studentLabel = new JLabel("Student ID");
        passwordLabel = new JLabel("Password");
        studentField = new JTextField(10);
        passwordField = new JPasswordField();
        loginButton = new JButton("Enter");

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
        String student = studentField.getText();
        String password = new String(passwordField.getPassword());

        if (validateForm(student, password)) {

        }
    }

    private boolean validateForm(String student, String password) {
        boolean containsError = false;
        message = new Messages();

        if (student.equals("") && password.equals("")) {
            containsError = true;
            JOptionPane.showMessageDialog(null, message.getMessage("studentpasswordfield_error"), "Warning", JOptionPane.ERROR_MESSAGE);
        } else if (student.equals("")) {
            containsError = true;
            JOptionPane.showMessageDialog(null, message.getMessage("studentfield_error"), "Warning", JOptionPane.ERROR_MESSAGE);
        } else if (password.equals("")) {
            containsError = true;
            JOptionPane.showMessageDialog(null, message.getMessage("passwordfield_error"), "Warning", JOptionPane.ERROR_MESSAGE);
        }

        if (containsError) {
            return false;
        }
        return true;
    }

    private JLabel studentLabel;
    private JLabel passwordLabel;
    private JTextField studentField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private Messages message;
}
