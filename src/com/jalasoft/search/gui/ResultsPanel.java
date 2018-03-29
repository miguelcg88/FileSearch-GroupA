package com.jalasoft.search.gui;

import javax.swing.*;
import java.awt.*;

public class ResultsPanel extends JPanel {

    private JPanel resultsPanel;

    public ResultsPanel(){
        makeResultsPanel();
    }

    /* Initializes result panel*/
    private void makeResultsPanel() {
        resultsPanel = new JPanel();
        resultsPanel.setLayout(new BorderLayout());
        resultsPanel.setBackground(Color.black);
    }

    public JPanel getResultsPanel(){
        return resultsPanel;
    }

}
