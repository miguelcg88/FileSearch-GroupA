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
package src.com.jalasoft.search;

import src.com.jalasoft.search.model.SearchModel;
import src.com.jalasoft.search.Controller.SearchController;
import src.com.jalasoft.search.gui.MainFileSearch;
import src.com.jalasoft.search.gui.ResultsPanel;
import src.com.jalasoft.search.gui.SimpleSearchPanel;
import src.com.jalasoft.search.model.Search;

/**
 * Main MVC Search
 *
 * @version 1.00 23 Mar 2018
 * @author Gabriel Rendon  */
public class MVCSearch {
    //Test purposes
    public static void main(String[] args) {
        MainFileSearch view = new MainFileSearch("MI");
        Search model  = new Search();
        SimpleSearchPanel simpleFilters = new SimpleSearchPanel();
        ResultsPanel results = new ResultsPanel();
        SearchController controller = new SearchController(model, view, simpleFilters, results);
    }
}
