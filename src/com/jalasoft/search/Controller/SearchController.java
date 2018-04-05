/*
 * @(#)SearchController.java        1.00 3/22/18
 *
 * Copyright (c) Jalasoft
 *
 * This software is the confidential and proprietary information of Jalasoft
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package src.com.jalasoft.search.Controller;

//import java.util.logging.Logger;
import com.jalasoft.search.model.SearchModel;
import src.com.jalasoft.search.common.Validator;
import src.com.jalasoft.search.gui.MainFileSearch;
import src.com.jalasoft.search.gui.ResultsPanel;
import src.com.jalasoft.search.gui.SimpleSearchPanel;
import src.com.jalasoft.search.model.FileSearch;
import src.com.jalasoft.search.model.Search;
import src.com.jalasoft.search.model.SearchCriteria;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

/**
 * SearchController
 *
 * @version 1.00 23 Mar 2018
 * @author Gabriel Rendon  */
public class SearchController {
    /* Controller. */
    /**
     * private model, view
     */
    private Search model;
    private MainFileSearch view;
    private SimpleSearchPanel simpleFilters;

    private SearchCriteria criteria;
    private Validator validator = new Validator();

    public SearchController(Search model, MainFileSearch view, SimpleSearchPanel simpleFilters, ResultsPanel results) {
        this.model = model;
        this.view = view;
        this.simpleFilters = simpleFilters;
        //this.results = results;
        this.view.getSearchButton().addActionListener(e -> FillCriteria());
    }

    private void FillCriteria() {
        criteria = new SearchCriteria();
        String fileName = this.view.getFileName();

        if (validator.isValidName(fileName)) {
            this.criteria.setFileName(fileName);
        } else {
            // TO DO
            // Need to pass the error to UI
            // this.view.setError(fileName+" is an invalid File Name");
        }

        String filePath = this.view.getPath();
        if (validator.isValidPath(filePath)) {
            this.criteria.setFolderPath(filePath);
        } else {
            // TO DO
            // Need to pass the error to UI
            //results.setError(filePath+" is an invalid File Path");
        }

        Boolean hidden = this.view.getHidden();
        this.criteria.setHiddenFlag(hidden);

        String extension = this.view.getExtension();
        if (validator.isValidExtension("test." + extension)) {
            System.out.println("The Extension [" + extension + "] is a valid File Extension");
            this.criteria.setExtension(extension);
        } else {
            // TO DO
            // Need to pass the error to UI
            //results.setError(filePath+" is an invalid File Extension");
        }

        // Send Search criterial to model.
        model.setSearchCriteria(criteria);
        model.searchByHiddenAttribute();

        // List with all search result.
        ArrayList<File> fileResults = model.getResults();
        String data[] = new String[4];

        // Clean table
        this.view.getTable().setRowCount(0);

        // Set search result in table
        for (int i = 0; i < fileResults.size(); i++) {
            String nameText = fileResults.get(i).getName().replaceFirst("[.][^.]+$", "");
            data[0] = nameText;
            data[1] = fileResults.get(i).getPath();

            String hiddenText = (fileResults.get(i).isHidden()) ? "Yes" : "No";
            data[2] = hiddenText;

            String extensionText =  fileResults.get(i).getName().substring(fileResults.get(i).getName().lastIndexOf(".")+1);
            data[3] = extensionText;

            this.view.getTable().addRow(data);
        }
    }
}
