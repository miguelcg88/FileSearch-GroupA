package com.jalasoft.search.Controller;

public class MVCSearch {
    public static void main(String[] args) {

        SearchView view = new SearchView();
        SearchModel model  = new SearchModel();

        SearchController controller = new SearchController(model, view);

        controller.updateView();
        controller.setFileName("test");
        controller.updateView();
    }
}
