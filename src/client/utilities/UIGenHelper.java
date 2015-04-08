/*
 * University Library, UP Los Banos
 * Computer Usage Tracking System
 */
package client.utilities;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author tbcabagay
 */
public class UIGenHelper {

    UIGenHelper() {
    }

    public static void addToGrid(JPanel jpanel, Component component, int i, int j, int k, int l, int i1, int j1,
            int k1, int l1) {
        GridBagConstraints gridbagconstraints = new GridBagConstraints(i, j, k, l, i1, j1, k1, l1, new Insets(5, 5, 5, 5), 0, 0);
        jpanel.add(component, gridbagconstraints);
    }

    public static void applyBorder(JPanel jpanel, String title) {
        Border innerBorder = BorderFactory.createTitledBorder(title);
        Border outerBorder = BorderFactory.createEmptyBorder(20, 10, 20, 10);
        jpanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
    }

    public static String readHelpText(String s) {
        String s1 = "";
        try {
            FileReader filereader = new FileReader(s);
            for (char ac[] = new char[10]; filereader.read(ac, 0, 10) != -1; ac = new char[10]) {
                String s2 = new String(ac);
                s1 = (new StringBuilder()).append(s1).append(s2).toString();
            }

        } catch (IOException ioexception) {
            System.out.println((new StringBuilder()).append("SignupPanel.readHelpText()-Error:").append(ioexception).toString());
        }
        return s1;
    }
}
