package orms;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain_objects.Framework;
import domain_objects.Framework;

public class FrameworkORM implements ORM<Framework>{

    public String projection() {
        return "id, name";
    }

    public String table() {
        // TODO Auto-generated method stub
        return "Frameworks";
    }

    public Framework map(ResultSet results) throws SQLException {
        Framework framework = new Framework();
        framework = framework.setId(results.getInt(1));
        framework = framework.setName(results.getString(2));
        
        return framework;  
    }

    public Framework eagerMap(ResultSet results) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    public String prepareInsert() {
        // TODO Auto-generated method stub
        return "INSERT INTO " + table() + " (name) VALUES(?) ";
    }


    public String prepareEagerRead(String table2) {
        // TODO Auto-generated method stub
        return "SELECT * FROM " + table() + " INNER JOIN " + table2 + " ON "; 
    }

    public String prepareRead() {
        // TODO Auto-generated method stub
        return "SELECT * FROM " + table() + " WHERE id = ?";
    }

    public String prepareDelete() {
        // TODO Auto-generated method stub
        return "DELETE FROM " + table() + " WHERE id = ?";
    }


}
