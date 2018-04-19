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
import src.com.jalasoft.search.DB.SearchQuery;
import src.com.jalasoft.search.common.Convertor;
import src.com.jalasoft.search.common.Validator;
import src.com.jalasoft.search.gui.ErrorDialog;
import src.com.jalasoft.search.gui.MainFileSearch;
import src.com.jalasoft.search.gui.ResultsPanel;
import src.com.jalasoft.search.gui.SimpleSearchPanel;
import src.com.jalasoft.search.model.Asset;
import src.com.jalasoft.search.model.Search;
import src.com.jalasoft.search.model.SearchCriteria;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * SearchController
 *
 * @version 1.00 23 Mar 2018
 * @author Gabriel Rendon  */
public class SearchController {
    /* Controller. */
    /**
     * private model, view (main simplesearch) validator convertor criteria
     */
    private Search model;
    private MainFileSearch view;
    private SimpleSearchPanel simpleFilters;
    private SearchCriteria criteria;
    private Validator validator = new Validator();
    private Convertor convert = new Convertor();
    private Logger logger = LoggerCreator.getInstance().getLogger();
    private ErrorDialog error = new ErrorDialog();

    /**
     * Search Controller Parameters
     * @param model
     * @param view
     * @param simpleFilters
     * @param results
     */
    public SearchController(Search model, MainFileSearch view, SimpleSearchPanel simpleFilters, ResultsPanel results) {
        this.model = model;
        this.view = view;
        this.simpleFilters = simpleFilters;
        this.view.getSearchButton().addActionListener(e -> {
            try {
                FillCriteria();
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        });
/*
        this.view.getRecentSearchaButton().addActionListener(e -> {
            try {
                GetSavedCriterias();
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        });*/
    }

    /**
     * Fill Criteria will listen UI and sent Criteria to the Model
     * Retrieve Results from Model and Sent them to UI
     */
    private void FillCriteria() throws SQLException, ClassNotFoundException {
        criteria = new SearchCriteria();

        // Clean table
        this.view.getTable().setRowCount(0);

        if(view.panelFlag == "simple") {
            logger.info("SIMPLE SEARCH");
            String fileName = this.view.getFileNameFromSimpleSearch();
            if (validator.isValidName(fileName)) {
                this.criteria.setFileName(fileName);
                if (fileName == null || fileName.isEmpty()) fileName = "[null]";
                logger.info("FileName criteria set as: " + fileName);
            } else {
                logger.warning("FileName criteria is not valid");
                // TO DO
                // Need to pass the error to UI
                // this.view.setError(fileName+" is an invalid File Name");
            }

            String filePath = this.view.getPathFromSimpleSearch();
            if (validator.isValidPath(filePath)) {
                this.criteria.setFolderPath(filePath);
                logger.info("FilePath criteria set as: " + filePath);
            } else {
                logger.warning("FilePath criteria is not valid");
                // TO DO
                // Need to pass the error to UI
                //results.setError(filePath+" is an invalid File Path");
            }

            Boolean hidden = this.view.getHiddenFromSimpleSearch();
            this.criteria.setHiddenFlag(hidden);
            logger.info((hidden == true) ? "Criteria was set to Include Hidden" : "Criteria was set to Exclude hidden");

            String extension = this.view.getExtensionFromSimpleSearch();
            if (validator.isValidExtension("test." + extension)) {
                this.criteria.setExtension(extension);
                logger.info("Extension criteria set as: " + extension);
            } else {
                logger.warning("Extension criteria is not valid");
                // TO DO
                // Need to pass the error to UI
                //results.setError(filePath+" is an invalid File Extension");
            }
        }

        if(view.panelFlag == "advanced"){
            logger.info("ADVANCED SEARCH");
            String fileName = this.view.getFileNameFromAdvancedSearch();
            if (validator.isValidName(fileName)) {
                this.criteria.setFileName(fileName);
                if(fileName == null || fileName.isEmpty())fileName="[null]";
                logger.info("FileName criteria set as: " +fileName);
            } else {
                logger.warning("FileName criteria is not valid");
                // TO DO
                // Need to pass the error to UI
                // this.view.setError(fileName+" is an invalid File Name");
            }

            String filePath = this.view.getPathFromAdvancedSearch();
            if (validator.isValidPath(filePath)) {
                this.criteria.setFolderPath(filePath);
                logger.info("FilePath criteria set as: "+filePath);
            } else {
                logger.warning("FilePath criteria is not valid");
                // TO DO
                // Need to pass the error to UI
                //results.setError(filePath+" is an invalid File Path");
            }

            Boolean hidden = this.view.getHiddenFromAdvancedSearch();
            this.criteria.setHiddenFlag(hidden);
            logger.info((hidden==true)? "Criteria was set to Include Hidden" : "Criteria was set to Exclude hidden");

            String extension = this.view.getExtensionFromAdvancedSearch();
            if (validator.isValidExtension("test." + extension)) {
                this.criteria.setExtension(extension);
                logger.info("Extension criteria set as: "+extension);
            } else {
                logger.warning("Extension criteria is not valid ["+extension);
                // TO DO
                // Need to pass the error to UI
                //results.setError(filePath+" is an invalid File Extension");
            }

            this.criteria.setContent(this.view.getContains());
            logger.info("Content criteria set as: "+this.view.getContains());
            this.criteria.setOwner(this.view.getCreatedBy());
            logger.info("Created by criteria set as: "+this.view.getCreatedBy());


            if(validator.isValidDate(this.view.getCreatedDate1FromAdvancedSearch())){
                this.criteria.setCreationDateFrom(this.view.getCreatedDate1FromAdvancedSearch());
                logger.info("CreationDate From criteria set as: "+this.view.getCreatedDate1FromAdvancedSearch());}
            else {
                logger.warning("Created Date From criteria is not valid - needed format yyyy-dd-MM");
                //error.
            }

            if(validator.isValidDate(this.view.getCreatedDate2FromAdvancedSearch())){
                this.criteria.setCreationDateTo(this.view.getCreatedDate2FromAdvancedSearch());
                logger.info("Creation Date To criteria set as: "+this.view.getCreatedDate2FromAdvancedSearch());}
            else {
                logger.warning("Created Date From criteria is not valid - needed format yyyy-dd-MM");
                //error.
            }

            if(validator.isValidDate(this.view.getModifiedDate1FromAdvancedSearch())){
                this.criteria.setModificationDateFrom(this.view.getModifiedDate1FromAdvancedSearch());
                logger.info("Modification Date From criteria set as: "+this.view.getModifiedDate1FromAdvancedSearch());}
            else {
                logger.warning("Created Date From criteria is not valid - needed format yyyy-dd-MM");
                //error.
            }

            if(validator.isValidDate(this.view.getModifiedDate2FromAdvancedSearch())){
                this.criteria.setModificationDateTo(this.view.getModifiedDate2FromAdvancedSearch());
                logger.info("Modification Date To criteria set as: "+this.view.getModifiedDate2FromAdvancedSearch());}
            else {
                logger.warning("Created Date From criteria is not valid - needed format yyyy-dd-MM");
                //error.
            }
        }


        // Send Search criterial to model.
        logger.info("Sendding Search criteria to model.");
        model.setSearchCriteria(criteria);

        //save criteria
        /*
        if(view.getNameSaveCriteria != null){
            //Converting criteria to Json string
            //String jsonString = convert.ObjectToJson(criteria);
            logger.info("saving criteria in DB");
            SearchQuery query = new SearchQuery();
            query.saveCriteria(view.getNameSaveCriteria, criteria);
        }
        */

        //model.setResults();
        logger.info("Searching");
        model.getAllFileByPath(criteria.getFilePath());

        // List with all search result.
        logger.info("Getting results from model.");
        ArrayList<Asset> fileResults = model.getResults();
        System.out.println(fileResults.size());
        String data[] = new String[5];

        // Clean table
        this.view.getTable().setRowCount(0);

        // Set search result in table
        for (int i = 0; i < fileResults.size(); i++) {
            String nameText = fileResults.get(i).getFileName().replaceFirst("[.][^.]+$", "");
            //String nameText = fileResults.get(i).getFileName();
            data[0] = nameText;
            data[1] = fileResults.get(i).getFilePath();

            String hiddenText = (fileResults.get(i).getHiddenFlag()) ? "Yes" : "No";
            data[2] = hiddenText;

            String extensionText =  fileResults.get(i).getFileName().substring(fileResults.get(i).getFileName().lastIndexOf(".")+1);
            data[3] = extensionText;

            File file = new File (fileResults.get(i).getFilePath());
            long size =  file.length();
            String sizeText = Long.toString(convert.ConvertBytesToMegabytes(size));
            data[4] = sizeText;

            this.view.getTable().addRow(data);
        }

        /*
        public void GetSavedCriterias(){
            SearchQuery query = new SearchQuery();
            view.PrintResultSet(query.getAllCriteria());
        }
        */
    }
}
