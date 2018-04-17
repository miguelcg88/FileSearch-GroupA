
/*
 * MainFileSearch.java  1.0  3/16/2018
 * Copyright (c) 2018  Jalasoft
 * All rights reserved.
 *Author : Miguel Calderon
 */

package src.com.jalasoft.search.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
//Class that creates popup to display errors

public class ErrorDialog {
    private static String error;





    public JFrame setErrorMessage (String e) {
        error = e;
        JFrame frame = new JFrame("Error message");
        JOptionPane.showMessageDialog(frame,
                error );
        System.exit(0);

        return  frame;
    }
}

