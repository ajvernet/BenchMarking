package orms;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain_objects.Framework;
import domain_objects.Language;
import domain_objects.Server;

public class FrameworkORM implements ORM<Framework>{

    public String projection() {
        return "(name, language, server, rps_8, rps_16, rps_32, rps_64, rps_128, rps_256, errors)";
     
    }

    public String table() {
        // TODO Auto-generated method stub
        return "Frameworks";
    }

    public Framework map(ResultSet results) throws SQLException {
        Framework framework = new Framework();
        framework = framework.setId(results.getInt(1));
        framework = framework.setName(results.getString(2));
        framework = framework.setLanguage(new Language(results.getString(3)));
        
        return framework;  
    }

    public Framework eagerMap(ResultSet results) throws SQLException {
        Framework framework = new Framework();
        framework = framework.setId(results.getInt(1));
        framework = framework.setName(results.getString(2));
        framework = framework.setLanguage(new Language(results.getString(3)));
        framework = framework.setServer(new Server(results.getString(4)));
        framework = framework.setRPS_8(results.getInt(5));
        framework = framework.setRPS_16(results.getInt(6));
        framework = framework.setRPS_32(results.getInt(7));
        framework = framework.setRPS_64(results.getInt(8));        
        framework = framework.setRPS_128(results.getInt(9));
        framework = framework.setRPS_256(results.getInt(10));
        framework = framework.setErrors(results.getInt(11));
        
        return framework;  
    }

    public String prepareInsert() {
        // TODO Auto-generated method stub
        return "INSERT INTO " + table() + " " + projection() + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }


    public String prepareEagerRead(String table2) {
        // TODO Auto-generated method stub
        return "SELECT * FROM " + table() + " INNER JOIN " + table2 + " ON "; 
    }
    
    public String prepareEagerReadAddition(String table3){
        
        return " INNER JOIN " + table3 + " ON ";
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
