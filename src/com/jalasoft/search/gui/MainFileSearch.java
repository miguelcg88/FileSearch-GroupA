/*
 * MainFileSearch.java  1.0  3/16/2018
 * Copyright (c) 2018  Jalasoft
 * All rights reserved.
 *Author : Miguel Calderon
 */

package com.jalasoft.search.gui;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
// Class that creates mainframe for project, contains another panels acccording which kind of search is selected by user
public class MainFileSearch extends JFrame {

    private JButton searchButton;
    private JPanel northPanel;
    private JPanel resultsPanel;


    //Class constructor, calls methods to make panels
    public MainFileSearch(String title) {
        super(title);
        makeNorthPanel();
        initializeMainFrame();
    }

    /* Initializes main frame by adding all panels in it and set properties for window*/
    private void initializeMainFrame(){
        JFrame mainFrame = new JFrame();
        mainFrame.pack();
        mainFrame.setLayout(new BorderLayout());
        resultsPanel = new ResultsPanel();
        mainFrame.add(resultsPanel);
        mainFrame.add(northPanel,BorderLayout.NORTH);
        mainFrame.add(resultsPanel,BorderLayout.CENTER );
        mainFrame.setSize(700, 550);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        northPanel.add(simpleSearchPanel,BorderLayout.CENTER);
        northPanel.add(leftPanel,BorderLayout.WEST);
        northPanel.add(searchButton,BorderLayout.EAST);
    }

    //Method to communicate to Controller when search button is pressed
    public JButton getSearchButton(){
        return searchButton;
    }

    public static void main(String[] args) {
        new MainFileSearch("File Search");
    }
}

