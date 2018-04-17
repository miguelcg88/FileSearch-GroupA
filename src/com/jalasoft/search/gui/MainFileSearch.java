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
    SavedSearchsPanel savedSearchsPanel;
    private String panelFlag;

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
        savedSearchsPanel = new SavedSearchsPanel();
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
        advancedSearchPanel = new AdvancedSearchPanel();

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
                northPanel.repaint();
                northPanel.revalidate();
                northPanel.add(simpleSearchPanel);
                northPanel.repaint();
                northPanel.revalidate();
                panelFlag = "simple";


            }
        });

        advancedSearchButton = new JButton("Advanced");
        advancedSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                northPanel.remove(simpleSearchPanel);
                northPanel.repaint();
                northPanel.revalidate();
                northPanel.add(advancedSearchPanel);
                northPanel.repaint();
                northPanel.revalidate();
                panelFlag = "advanced";
            }
        });
        videoSearchButton = new JButton("Video");
        musicSearchButton = new JButton("Music");
        recentSearchsButton = new JButton("Recent Searchs");
        recentSearchsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                resultsPanel.remove(resultsPanel);
                resultsPanel.repaint();
                resultsPanel.revalidate();
                resultsPanel.add(savedSearchsPanel);
                resultsPanel.repaint();
                resultsPanel.revalidate();
                //aqui debo agregar al frame en vez del resultspanel
            }
        });


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
    public String getFileNameFromSimpleSearch(){
        return this.simpleSearchPanel.getFileNameField();
    }
    public String getPathFromSimpleSearch(){
        return this.simpleSearchPanel.getPathNameField();
    }
    public String getExtensionFromSimpleSearch(){
        return this.simpleSearchPanel.getExtensionComboBox();
    }
    public Boolean getHiddenFromSimpleSearch(){
        return this.simpleSearchPanel.getHiddenCheckbox();
    }


    public String getFileNameFromAdvancedSearch(){
        return this.advancedSearchPanel.getFileNameField();
    }
    public String getPathFromAdvancedSearch(){
        return this.advancedSearchPanel.getPathNameField();
    }
    public String getExtensionFromAdvancedSearch(){
        return this.advancedSearchPanel.getExtensionComboBox();
    }
    public Boolean getHiddenFromAdvancedSearch(){
        return this.advancedSearchPanel.getHiddenCheckbox();
    }
    public String getCreatedDate1FromAdvancedSearch(){return this.advancedSearchPanel.getCreatedDateFrom();}
    public String getCreatedDate2FromAdvancedSearch(){return this.advancedSearchPanel.getCreatedDateTo();}
    public String getModifiedDate1FromAdvancedSearch(){return this.advancedSearchPanel.getModifiedDateFrom();}
    public String getModifiedDate2FromAdvancedSearch(){return this.advancedSearchPanel.getModifiedDateTo();}
    public String getContains(){return this.advancedSearchPanel.getContainsText();}
    public String getCreatedBy(){return this.advancedSearchPanel.getCreatedByText();}

    public String getPanelFlag(){return this.panelFlag;}

    public void setSavedSearchs(){ //to do

    }





    public DefaultTableModel getTable(){
        return resultsPanel.getResultsTable();
    }
}
