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
package src.com.jalasoft.search.DB;

import src.com.jalasoft.search.common.Convertor;
import src.com.jalasoft.search.model.SearchCriteria;

import javax.management.relation.RelationSupport;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Search Criteria
 *
 * @version 1.00 26 Mar 2018
 * @author Gabriel Rendon  */
public class SearchQuery {
    private static Connection con;

    public SearchQuery() throws SQLException, ClassNotFoundException {
        con = DBConnection.getInstance().getConnection();
    }

    public String AddCriteria(String criteriaName, String externalJson) throws SQLException {
        String query = "INSERT INTO SearchGroupA (Id, CriteriaName, Json) Values(1,2,3)";
        PreparedStatement pre = con.prepareStatement(query);
        pre.setString(2,criteriaName);
        pre.setString(3,externalJson);
        pre.execute();
        return "Success";
    }

    public ResultSet getAllCriteria(){
        Statement state = null;
        try {
            state = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet result = null;
        try {
            result = state.executeQuery("Select Id,CriteriaName,Json From SearchGroupA");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  result;
    }
/*
    public String saveCriteria(String name, SearchCriteria criteria){
        try{
            SearchQuery dbh = new SearchQuery();
            Convertor convertor = new Convertor();
            String jsonString = convertor.ObjectToJson(criteria);
            dbh.AddCriteria(name, jsonString);
        }
        catch(SQLException e){
            return "error";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "success";
    }

    public Map<Integer,SearchCriteria> getAllData()
    {
        Map<Integer,SearchCriteria> scMap = new HashMap<>();

        SearchQuery dbh = new SearchQuery();
        ResultSet set = dbh.getAllCiteria();

        Gson gson = new Gson();
        While(set.next()) {
        SearchCriteria criteria = gson.fromJson(json, SearchCriteria.class);
        int id = set.getInt("Id");
        scMap.put(id, criteria);
    }

    return scMap;
    }
    */
}
