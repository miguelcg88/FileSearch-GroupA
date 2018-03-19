package com.jalasoft.search.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchController {
    private SearchModel model;
    private SearchView view;

    public SearchController(SearchModel model, SearchView view){
        this.model = model;
        this.view = view;

        this.view.addSearchListener(new SearchListener());
    }

    public class SearchListener implements ActionListener {


        public void actionPerformed(ActionEvent action){
            //Log action here
            try{
                action = view.getCriteria();
                model.setCriteria(action);
                view.search(model.getResult());
            }
        }
    }
}
