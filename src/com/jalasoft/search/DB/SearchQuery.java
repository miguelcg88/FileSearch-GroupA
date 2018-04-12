package src.com.jalasoft.search.DB;

import javax.management.relation.RelationSupport;
import java.sql.*;


public class SearchQuery {
    private static Connection con;

    public SearchQuery() throws SQLException, ClassNotFoundException {
        con = DBConnection.getInstance().getConnection();
    }

    public String addCriteria(String criteriaName, String externalJson) throws SQLException {
        String query = "INSERT INTO SearchGroupA (Id, CriteriaName, Json) Values(1,2,3)";
        PreparedStatement pre = con.prepareStatement(query);
        pre.setString(2,criteriaName);
        pre.setString(3,externalJson);
        pre.execute();
        return "";
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
