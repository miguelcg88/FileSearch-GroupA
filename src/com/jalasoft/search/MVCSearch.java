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
package com.jalasoft.search;

import com.jalasoft.search.model.SearchModel;
/**
 * Main MVC Search
 *
 * @version 1.00 23 Mar 2018
 * @author Gabriel Rendon  */
public class MVCSearch {
    //Test purposes
    public static void main(String[] args) {
        String fixedPath = "C:\\TestFolder";
        //SearchView view = new SearchView();
        SearchModel model  = new SearchModel();
        model.ListFileByPath(fixedPath);

        //SearchController controller = new SearchController(model, view);

        //controller.updateView();
        //controller.setFileName("test");
        //.updateView();
    }
}
