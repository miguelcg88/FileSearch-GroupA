/*
 * MainFileSearch.java  1.0  3/16/2018
 * Copyright (c) 2018  Jalasoft
 * All rights reserved.
 *Author : Miguel Calderon
 */

package src.com.jalasoft.search.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Class that creates mainframe for project, contains another panels acccording which kind of search is selected by user
public class MainFileSearch extends JFrame {

    private JButton searchButton;
    private JButton simpleSearchButton;
    private JButton advancedSearchButton;
    private JButton videoSearchButton;
    private JButton musicSearchButton;
    private JButton recentSearchsButton;
    private JTextField searchString;
    private JPanel searchOptionsPanel;
    private JPanel leftPanel;
    private JPanel northPanel;
    private ResultsPanel resultsPanel;
    SimpleSearchPanel simpleSearchPanel;
    AdvancedSearchPanel advancedSearchPanel;

    //Class constructor, calls methods to make panels
    public MainFileSearch(String title) {
        makeNorthPanelForSimpleSearch();
        initializeMainFrame();
    }

    /* Initializes main frame by adding all panels in it and set properties for window*/
    private void initializeMainFrame(){
        pack();
        setLayout(new BorderLayout());
        resultsPanel = new ResultsPanel();
        add(resultsPanel);
        add(northPanel,BorderLayout.NORTH);
        add(resultsPanel,BorderLayout.CENTER );
        setSize(700, 550);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /* Initializes panel that contains 2 other panels, one for search criteria and
    other one is left panel that contains buttons to select what kind of search want to use*/
    private void makeNorthPanelForSimpleSearch() {
        northPanel = new JPanel();
        searchButton = new JButton("Go !");
        northPanel.setLayout(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(750,280));
        simpleSearchPanel = new SimpleSearchPanel();
        simpleSearchPanel.add(simpleSearchPanel.getSimpleSearchPrincipalPanel());
        makeLeftPanel();
        northPanel.add(simpleSearchPanel,BorderLayout.CENTER);
        northPanel.add(leftPanel,BorderLayout.WEST);
        northPanel.add(searchButton,BorderLayout.EAST);
        northPanel.setVisible(true);

    }
   /* //Initializes advanced panel when user click on "Advanced" button
    private void makeNorthPanelForAdvancedSearch(){
        northPanel = new JPanel();
        searchButton = new JButton("Go !");
        northPanel.setLayout(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(750,280));
        advancedSearchPanel = new AdvancedSearchPanel();
        makeLeftPanel();
        northPanel.add(advancedSearchPanel,BorderLayout.CENTER);
        northPanel.add(leftPanel,BorderLayout.WEST);
        northPanel.add(searchButton,BorderLayout.EAST);
        northPanel.setVisible(true);

    }*/

    /* Initializes left panel that contains buttons to select what kind of search want you use*/
    private void makeLeftPanel() {
        leftPanel = new JPanel();
        simpleSearchButton = new JButton("Simple");
        simpleSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                northPanel.remove(advancedSearchPanel);
                simpleSearchPanel = new SimpleSearchPanel();
                simpleSearchPanel.setVisible(true);
                northPanel.add(simpleSearchPanel);
                northPanel.revalidate();
            }
        });

        advancedSearchButton = new JButton("Advanced");
        advancedSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                northPanel.remove(simpleSearchPanel);
                advancedSearchPanel = new AdvancedSearchPanel();
                northPanel.add(advancedSearchPanel);
                northPanel.revalidate();
            }
        });
        videoSearchButton = new JButton("Video");
        musicSearchButton = new JButton("Music");
        recentSearchsButton = new JButton("Recent Searchs");
        leftPanel.setLayout(new GridLayout(5,1));
        leftPanel.setBackground(Color.darkGray);
        leftPanel.add(simpleSearchButton);
        leftPanel.add(advancedSearchButton);
        leftPanel.add(videoSearchButton);
        leftPanel.add(musicSearchButton);
        leftPanel.add(recentSearchsButton);
    }

    public JButton getSearchButton(){
        return searchButton;
    }

    public String getFileName(){
        return this.simpleSearchPanel.getFileNameField();
    }

    public String getPath(){
        return this.simpleSearchPanel.getPathNameField();
    }

    public String getExtension(){
        return this.simpleSearchPanel.getExtensionComboBox();
    }

    public Boolean getHidden(){
        return this.simpleSearchPanel.getHiddenCheckbox();
    }

    public DefaultTableModel getTable(){
        return resultsPanel.getResultsTable();
    }
}
