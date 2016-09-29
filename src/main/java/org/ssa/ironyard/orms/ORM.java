package org.ssa.ironyard.orms;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ORM<T> {
    String projection();

    String table();

    T map (ResultSet results) throws SQLException;
    
    T eagerMap (ResultSet results) throws SQLException;

    String prepareInsert();

    String prepareUpdate();

    String prepareEagerRead(String table2);
    
    String prepareReadAll();
    
    String prepareRead();

    String prepareDelete();

}
