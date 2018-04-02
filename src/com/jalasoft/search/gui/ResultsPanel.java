package com.jalasoft.search.gui;

import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.*;
//Class that creates results panel
public class ResultsPanel extends JPanel {


    public ResultsPanel(){
        makeResultsPanel();
    }
    // Initializes result panel
    public void makeResultsPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.black);
    }


}

