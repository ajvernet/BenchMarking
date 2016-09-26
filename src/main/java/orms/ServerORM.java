package orms;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain_objects.Language;

public class ServerORM implements ORM<Language>{

    public String projection() {
        return "id, name";
    }

    public String table() {
        // TODO Auto-generated method stub
        return "Languages";
    }

    public Language map(ResultSet results) throws SQLException {
        Language language = new Language();
        language = language.setId(results.getInt(1));
        language = language.setName(results.getString(2));
        
        return language;  
    }

    public Language eagerMap(ResultSet results) throws SQLException {
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

    public String prepareUpdate() {
        // TODO Auto-generated method stub
        return null;
    }

    public String prepareEagerRead() {
        // TODO Auto-generated method stub
        return null;
    }



}
