package com.jalasoft.search.gui;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {

    private JButton normalSearchButton;
    private JButton advancedSearchButton;
    private JButton videoSearchButton;
    private JButton musicSearchButton;
    private JButton recentSearchsButton;
    private JPanel leftPanel;

    public LeftPanel(){
        makeLeftPanel();
    }

    //Initializes left panel that contains buttons to select what kind of search want you use
    private void makeLeftPanel() {
        leftPanel = new JPanel();
        normalSearchButton = new JButton("Simple");
        advancedSearchButton = new JButton("Advanced");
        videoSearchButton = new JButton("Video");
        musicSearchButton = new JButton("Music");
        recentSearchsButton = new JButton("Recent Searchs");
        leftPanel.setLayout(new GridLayout(5,1));
        leftPanel.add(normalSearchButton);
        leftPanel.add(advancedSearchButton);
        leftPanel.add(videoSearchButton);
        leftPanel.add(musicSearchButton);
        leftPanel.add(recentSearchsButton);
    }

    public JPanel getLeftPanel(){
        return leftPanel;
    }
}
