package src.com.jalasoft.search.Model;

import src.com.jalasoft.search.model.FileSearch;
import src.com.jalasoft.search.model.Asset;
import java.io.File;

public class FactoryAsset {
//    private String folderPath;
//    private String fileNameToSearch;
//    private Boolean isHidden;
//    private String owner;
//    private String modificationDate;
//    private String creationDate;

    public static Asset createAsset(String type, File asset, String owner) {
        String tempFolderPath = asset.getPath();
        String tempFileNameToSearch = asset.getName();
        Boolean tempIsHidden = asset.isHidden();
        String tempOwner =  owner;
        String tempExtensionFile = getExtensionFile(tempFileNameToSearch);
        if (type.equals("file")) {
            return new FileSearch(tempFolderPath, tempFileNameToSearch, tempIsHidden, tempOwner, tempExtensionFile);
        } else {
            //return new FolderSearch(tempFolderPath, tempFileNameToSearch, tempIsHidden, tempOwner);
            return new FileSearch(tempFolderPath, tempFileNameToSearch, tempIsHidden, tempOwner, tempExtensionFile);
            }
    }

    private static String getExtensionFile(String fileName) {
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
