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
    private JButton normalSearchButton;
    private JButton advancedSearchButton;
    private JButton videoSearchButton;
    private JButton musicSearchButton;
    private JButton recentSearchsButton;
    private JTextField searchString;
    private JPanel searchOptionsPanel;
    private JPanel leftPanel;
    private JPanel northPanel;
    private JPanel resultsPanel;
    private JPanel simpleSearchPanel;
    private JLabel searchLabel;
    SimpleSearchPanel simplePanel;

    //Class constructor, calls methods to make panels
    public MainFileSearch(String title) {
        //super(title);
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
        searchButton = new JButton("Go !");
        northPanel.setLayout(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(750,280));
        simplePanel = new SimpleSearchPanel();
        simplePanel.add(simplePanel.getSimpleSearchPrincipalPanel());
        makeLeftPanel();
        northPanel.add(simplePanel,BorderLayout.CENTER);
        northPanel.add(leftPanel,BorderLayout.WEST);
        northPanel.add(searchButton,BorderLayout.EAST);
        northPanel.setVisible(true);

    }

    /* Initializes left panel that contains buttons to select what kind of search want you use*/
    private void makeLeftPanel() {
        leftPanel = new JPanel();
        normalSearchButton = new JButton("Simple");
        advancedSearchButton = new JButton("Advanced");
        videoSearchButton = new JButton("Video");
        musicSearchButton = new JButton("Music");
        recentSearchsButton = new JButton("Recent Searchs");
        leftPanel.setLayout(new GridLayout(5,1));
        leftPanel.setBackground(Color.darkGray);
        leftPanel.add(normalSearchButton);
        leftPanel.add(advancedSearchButton);
        leftPanel.add(videoSearchButton);
        leftPanel.add(musicSearchButton);
        leftPanel.add(recentSearchsButton);
    }

    /* Initializes result panel*/
    private void makeResultsPanel() {
        resultsPanel = new JPanel();
        resultsPanel.setLayout(new BorderLayout());
        resultsPanel.setBackground(Color.lightGray);
    }
    public JButton getSearchButton(){
             return searchButton;
            }
    public String getFileName(){
        return this.simplePanel.getFileNameField();
    }

    public String getPath(){
        return this.simplePanel.getPathNameField();
    }


    public static void main(String[] args) {
        new MainFileSearch("File Search");
    }
}
