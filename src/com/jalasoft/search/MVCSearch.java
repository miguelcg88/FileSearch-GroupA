package com.jalasoft.search;
import com.jalasoft.search.model.SearchModel;

public class MVCSearch {
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
