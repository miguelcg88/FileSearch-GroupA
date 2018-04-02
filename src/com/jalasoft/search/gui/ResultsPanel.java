package src.com.jalasoft.search.gui;

import javax.swing.*;
import java.awt.*;
//Class that creates results panel
public class ResultsPanel extends JPanel {

    private JPanel resultsPanel;

    public ResultsPanel(){
        makeResultsPanel();
    }
    // Initializes result panel
    public void makeResultsPanel() {
        resultsPanel = new JPanel();
        resultsPanel.setLayout(new BorderLayout());
        resultsPanel.setBackground(Color.black);
    }
    //Returns the results panel
    public JPanel getResultsPanel(){
        return resultsPanel;
    }

}

