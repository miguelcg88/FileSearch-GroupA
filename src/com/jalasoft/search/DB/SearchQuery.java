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

import javax.management.relation.RelationSupport;
import java.sql.*;

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
}
