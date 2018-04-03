package com.jalasoft.search.gui;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {

    private JButton normalSearchButton;
    private JButton advancedSearchButton;
    private JButton videoSearchButton;
    private JButton musicSearchButton;
    private JButton recentSearchsButton;


    public LeftPanel(){
        makeLeftPanel();
    }

    //Initializes left panel that contains buttons to select what kind of search want you use
    private void makeLeftPanel() {
        normalSearchButton = new JButton("Simple");
        advancedSearchButton = new JButton("Advanced");
        videoSearchButton = new JButton("Video");
        musicSearchButton = new JButton("Music");
        recentSearchsButton = new JButton("Recent Searchs");
        setLayout(new GridLayout(5,1));
        add(normalSearchButton);
        add(advancedSearchButton);
        add(videoSearchButton);
        add(musicSearchButton);
        add(recentSearchsButton);
    }
}

