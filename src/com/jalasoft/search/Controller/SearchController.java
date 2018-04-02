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
import src.com.jalasoft.search.model.Search;
import src.com.jalasoft.search.model.SearchCriteria;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * SearchController
 *
 * @version 1.00 23 Mar 2018
 * @author Gabriel Rendon  */
public class SearchController {
    /* Controller. */
    /**
     private model, view */
    private Search model;
    private MainFileSearch view;
    private SimpleSearchPanel simpleFilters;
    private ResultsPanel results;
    private SearchCriteria criteria;
    private Validator validator = new Validator();

    public SearchController(Search model, MainFileSearch view, SimpleSearchPanel simpleFilters, ResultsPanel results){
        this.model = model;
        this.view = view;
        this.simpleFilters = simpleFilters;
        this.results = results;
       this.view.getSearchButton().addActionListener(e -> FillCriteria());
    }

    private void FillCriteria(){
        System.out.println("click");

        String fileName = this.simpleFilters.getFileNameField();
        if(validator.isValidName(fileName)){
            System.out.println(fileName + "is a valid File Name");
            this.criteria.setFileName(fileName);
        }
        else{
            //view.setError(fileName+" is an invalid File Name");
        }

        String filePath = this.simpleFilters.getPathNameField();
        if(validator.isValidPath(filePath)){
            System.out.println(filePath + "is a valid File Path");
            this.criteria.setFolderPath(filePath);
        }
        else{
            //results.setError(filePath+" is an invalid File Path");
        }

        Boolean hidden = this.simpleFilters.getHiddenCheckbox();
        this.criteria.setHiddenFlag(hidden);

        String extension = this.simpleFilters.getExtensionComboBox();
        if(validator.isValidExtension("test."+extension)){
            System.out.println(filePath + "is a valid File Extension");
            this.criteria.setExtension(extension);
        }
        else{
            //results.setError(filePath+" is an invalid File Extension");
        }
        //model.setSearchCriteria(criteria);


        /*
        * Search
        * List<Files> filesResults = search.getResults();
        * foreach(Files file : fileResults)
        *  {
        *   this.results.getGrid().row[0] = file.getName();
        *   this.results.getGrid().row[1] = file.getPath();
        *   this.results.getGrid().row[2] = file.getHidden();
        *   this.results.getGrid().row[3] = file.getExtension();
        *   this.results.getGrid().row[4] = file.getSize();
        *  }
         */
    }
}


