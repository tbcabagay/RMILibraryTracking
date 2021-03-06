/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui;

import client.utilities.UIGenHelper;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author tbcabagay
 */
public class AlertDialog extends JDialog implements ActionListener {

    public AlertDialog(TimerFrame timerFrame) {
        AlertDialog.timerFrame = timerFrame;

        initComponents();
    }

    private void initComponents() {
        setTitle("Attention!");

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int) (dimension.getWidth() / 2D - 50D), (int) (dimension.getHeight() / 2D - 30D));

        JPanel container = new JPanel();
        container.setLayout(new GridBagLayout());

        messageLabel = new JLabel("", new ImageIcon((new StringBuilder()).append("images").append(File.separator).append("timer-icon.png").toString()), 0);
        continueButton = new JButton("Continue");
        logoutButton = new JButton("Logout");

        UIGenHelper.addToGrid(container, messageLabel, 0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE);
        UIGenHelper.addToGrid(container, continueButton, 0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE);
        UIGenHelper.addToGrid(container, logoutButton, 1, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE);
        getContentPane().add(container);
        pack();

        continueButton.addActionListener(this);
        logoutButton.addActionListener(this);
    }

    public void setMessage(String message) {
        messageLabel.setText(message);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton activeButton = (JButton) e.getSource();

        if (activeButton == continueButton) {
            setVisible(false);
        } else if (activeButton == logoutButton) {
            TimerFrame.autoLogoff();
        }
    }

    private JLabel messageLabel;
    private static TimerFrame timerFrame;
    private JButton continueButton;
    private JButton logoutButton;
}
