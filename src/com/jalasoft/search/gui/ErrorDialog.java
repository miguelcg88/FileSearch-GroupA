package com.jalasoft.search.gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorDialog {
    private static String error;

    public static void main(String[] args)
    {
        error = "/Users/al/backups";
        JFrame frame = new JFrame("JOptionPane showMessageDialog example");
        JOptionPane.showMessageDialog(frame,
                "Problem writing to backup directory: '" + error + "'.");
        System.exit(0);
    }
}
