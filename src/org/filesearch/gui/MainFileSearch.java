/*
 * MainFileSearch.java  1.0  3/16/2018
 * Copyright (c) 2018  Jalasoft
 * All rights reserved.
 *Author : Miguel Calderon
 */

package org.filesearch.gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class MainFileSearch extends JFrame {

    private JButton searchButton,normalSearchButton,advancedSearchButton,videoSearchButton,musicSearchButton;
    private JTextField searchString;
    private JPanel searchOptionsPanel, leftPanel,northPanel,resultsPanel;


    public MainFileSearch(String title) {
        super(title);
        makeNorthPanel();
        makeResultsPanel();
        initializeMainFrame();
    }

    /* Initializes main frame by adding all panels in it and set properties for window*/
    private void initializeMainFrame(){

        JFrame mainPanel = new JFrame();
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
        northPanel.setLayout(new BorderLayout());
        makeSearchOptionsPanel();
        makeLeftPanel();
        northPanel.add(searchOptionsPanel,BorderLayout.CENTER);
        northPanel.add(leftPanel,BorderLayout.WEST);
    }

    /* Initializes search panel that contains a text field to enter search criteria and button to start search*/
    private void makeSearchOptionsPanel() {
        searchOptionsPanel = new JPanel();
        searchOptionsPanel.setLayout(new FlowLayout());
        searchString = new JTextField();
        searchString.setPreferredSize(new Dimension(200,50));
        searchButton = new JButton("Go!");
        searchOptionsPanel.add(searchString);
        searchOptionsPanel.add(searchButton);


    }

    /* Initializes result panel*/
    private void makeResultsPanel() {
        resultsPanel = new JPanel();
        resultsPanel.setLayout(new BorderLayout());
        resultsPanel.setBackground(Color.lightGray);
    }

    /* Initializes left panel that contains buttons to select what kind of search want you use*/
    private void makeLeftPanel() {
        leftPanel = new JPanel();
        normalSearchButton = new JButton("Simple");
        advancedSearchButton = new JButton("Advanced");
        videoSearchButton = new JButton("Video");
        musicSearchButton = new JButton("Music");
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(Color.darkGray);
        leftPanel.add(normalSearchButton);
        leftPanel.add(advancedSearchButton);
        leftPanel.add(videoSearchButton);
        leftPanel.add(musicSearchButton);
    }


    public static void main(String[] args) {
        new MainFileSearch("File Search");
    }
}