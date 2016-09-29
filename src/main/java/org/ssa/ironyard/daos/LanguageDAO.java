package org.ssa.ironyard.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.ssa.ironyard.domain_objects.Language;
import org.ssa.ironyard.orms.ORM;

public class LanguageDAO extends AbstractDAO<Language>{


    public LanguageDAO(DataSource datasource, ORM<Language> orm) {
        super(datasource, orm);
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public Language insert(Language domain)
    {
        Connection connection = null;
        PreparedStatement insertStatement = null;
        ResultSet keys = null;
        
        try{
            connection = this.datasource.getConnection();
            insertStatement = connection.prepareStatement(this.orm.prepareInsert(), Statement.RETURN_GENERATED_KEYS);
            
            insertStatement.setString(1, domain.getName());
            
            if(insertStatement.executeUpdate() > 0)
            {
                keys = insertStatement.getGeneratedKeys();
                if(keys.next())
                    
                    return domain.setId((keys.getInt(1)));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {closeAll(insertStatement, connection);}
        
        return null;
    }

    public void close() throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Language update(Language domain) {
        // TODO Auto-generated method stub
        return null;
    }

}
