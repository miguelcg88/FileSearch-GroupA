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

import com.jalasoft.search.model.SearchModel;
import src.com.jalasoft.search.common.Validator;
import src.com.jalasoft.search.gui.MainFileSearch;
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
    private SearchModel model;
    private MainFileSearch view;
    private SearchCriteria criteria;
    private Validator validator = new Validator();
    //search.getResults();

    public SearchController(SearchModel model, MainFileSearch view){
        this.model = model;
        this.view = view;
       // this.view.getSearchButton().addSearchListener(
              // e -> FillCriteria());
        //this.view.addSearchListener(new SearchListener());
    }
/*
    private void FillCriteria(){
        System.out.println("click");
        String fileName = this.view.getFileName();
        if(validator.isValidName(fileName)){
            System.out.println(fileName + "is a valid File Name");
            this.criteria.setFileName(fileName);
        }
        else{
            view.setError(fileName+" is an invalid File Name");
        }
        String filePath = this.view.getFilePath();
        if(validator.isValidPath(filePath)){
            System.out.println(filePath + "is a valid File Path");
        }
        else{
            view.setError(filePath+" is an invalid File Path");
        }
        Boolean hidden = this.view.getHidden();

    }*/
/*
    public class SearchListener implements ActionListener {
        public void actionPerformed(ActionEvent action){
            //Log action here
            try{
                action = view.getCriteria();
                //criteria.setCriteria(action);
                model.setCriteria(action);
                var results = model.getResult();
                view.printResults(results);
            }
        }
    }*/
}


