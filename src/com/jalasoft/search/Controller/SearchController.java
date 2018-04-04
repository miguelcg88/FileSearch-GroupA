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
     private model, view */
    private Search model;
    private MainFileSearch view;
    private SimpleSearchPanel simpleFilters;

    private SearchCriteria criteria;
    private Validator validator = new Validator();

    public SearchController(Search model, MainFileSearch view, SimpleSearchPanel simpleFilters, ResultsPanel results){
        this.model = model;
        this.view = view;
        this.simpleFilters = simpleFilters;
        //this.results = results;
       this.view.getSearchButton().addActionListener(e -> FillCriteria());
    }

    private void FillCriteria(){
        System.out.println("click");

        criteria = new SearchCriteria();
        String fileName = this.view.getFileName();
        if(validator.isValidName(fileName)){
            System.out.println("The Name ["+ fileName + "] is a valid File Name");
            this.criteria.setFileName(fileName);
        }
        else{
            //view.setError(fileName+" is an invalid File Name");
        }

        String filePath = this.view.getPath();
        if(validator.isValidPath(filePath)){
            System.out.println("The Path ["+ filePath + "] is a valid File Path");
            this.criteria.setFolderPath(filePath);
        }
        else{
            //results.setError(filePath+" is an invalid File Path");
        }

        Boolean hidden = this.view.getHidden();
        this.criteria.setHiddenFlag(hidden);

        String extension = this.view.getExtension();
        if(validator.isValidExtension("test."+extension)){
            System.out.println("The Extension ["+ extension + "] is a valid File Extension");
            this.criteria.setExtension(extension);
        }
        else{
            //results.setError(filePath+" is an invalid File Extension");
        }
        System.out.println("The Criteria Name is "+ criteria.getFileName());
        System.out.println("The Criteria Path is "+ criteria.getFilePath());
        System.out.println("The Criteria Hidden Flag is "+ criteria.getHiddenFlag());
        System.out.println("The Criteria Extension is "+ criteria.getExtension());
        //model.setSearchCriteria(criteria);



        //Search
        //List<FileSearch> filesResults = model.setResults();
        //ArrayList<File> fileResults = model.setResults();

        //String data [][] = new String[4][4];
        /*for (int i = 0; i < fileResults.size(); i++) {
            System.out.println("The Model Result["+i+"] name is: "+fileResults.get(i).getName());
            data[i][0]=fileResults.get(i).getName();
            data[i][1]=fileResults.get(i).getPath();
            data[i][2]=(fileResults.get(i).isHidden())? "Yes" : "No";
            data[i][3]= String.valueOf(fileResults.get(i).getName().endsWith("."));
        }*//*
        for (int i = 0; i < 4; i++) {
            data[i][0]="Name";
            data[i][1]="Path";
            data[i][2]="No";
            data[i][3]="txt";
        }*/
        String data[][]={ {"101","Amit","670000","zip","32"},
        {"102","Jai","780000","exe","3"},
        {"101","Sachin","700000","xls","12"}};
        System.out.println("Setting results to the view");

        ResultsPanel results = new ResultsPanel();
        results.setResults(data);

        System.out.println("Printing Results Panel");
        view.getResults();


        /*for(File file : fileResults)
        {
            String data [][] = {};


          this.results.setResults(data);
          makeResultsPanel();

                  .row[0] = file.getName();
          this.results.getGrid().row[1] = file.getPath();
          this.results.getGrid().row[2] = file.isHidden();
          this.results.getGrid().row[3] = file.getName().endsWith(".");*/
          //this.results.getGrid().row[4] = file.getSize();
        }

    }



