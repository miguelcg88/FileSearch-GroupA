/*
 * MainFileSearch.java  1.0  3/16/2018
 * Copyright (c) 2018  Jalasoft
 * All rights reserved.
 *Author : Miguel Calderon
 */

package src.com.jalasoft.search.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
// Class that creates mainframe for project, contains another panels acccording which kind of search is selected by user
public class MainFileSearch extends JFrame {

    private JButton searchButton;
    private JPanel northPanel;


    //Class constructor, calls methods to make panels
    public MainFileSearch(String title) {
        super(title);
        makeNorthPanel();
        initializeMainFrame();
    }

    /* Initializes main frame by adding all panels in it and set properties for window*/
    private void initializeMainFrame(){
        JFrame mainPanel = new JFrame();
        ResultsPanel resultsPanel = new ResultsPanel();
        resultsPanel.add(resultsPanel.getResultsPanel());
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(northPanel,BorderLayout.NORTH);
        mainPanel.add(resultsPanel,BorderLayout.CENTER );
        mainPanel.pack();
        mainPanel.setVisible(true);
        mainPanel.setSize(700, 550);
        mainPanel.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /* Initializes panel that contains 2 other panels, one for search criteria and
    other one is left panel that contains buttons to select what kind of search want to use*/
    private void makeNorthPanel() {
        northPanel = new JPanel();
        searchButton = new JButton("Go !");
        northPanel.setLayout(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(750,280));
        SimpleSearchPanel simpleSearchPanel = new SimpleSearchPanel();
        simpleSearchPanel.add(simpleSearchPanel.getSimpleSearchPrincipalPanel());
        LeftPanel leftPanel = new LeftPanel();
        leftPanel.add(leftPanel.getLeftPanel());
        northPanel.add(simpleSearchPanel,BorderLayout.CENTER);
        northPanel.add(leftPanel,BorderLayout.WEST);
        northPanel.add(searchButton,BorderLayout.EAST);
        northPanel.setVisible(true);
    }

    public JButton getSearchButton(){
        return searchButton;
    }
    //Method to communicate to Controller when search button is pressed
    public static void main(String[] args) {
        new MainFileSearch("File Search");
    }
}
