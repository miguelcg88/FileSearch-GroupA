package com.jalasoft.search.Model;

import src.com.jalasoft.search.model.FileSearch;

public class FactoryAsset {

    public static Asset createAsset(String type, String filePath) {
        if (type.equals("file")) {
            return new FileSearch(filePath);
        } else {
            return new FolderSearch(filePath);
            }
    }
}
