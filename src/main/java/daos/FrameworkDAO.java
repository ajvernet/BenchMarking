package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain_objects.Framework;
import orms.FrameworkORM;
import orms.ORM;

public class FrameworkDAO extends AbstractDAO<Framework>{

    public FrameworkDAO(DataSource datasource, FrameworkORM orm) {
        super(datasource, orm);
        // TODO Auto-generated constructor stub
    }

    public void close() throws Exception {
        // TODO Auto-generated method stub
        
    }


    public Framework insert(Framework domain) {
        Connection connection = null;
        PreparedStatement insertStatement = null;
        ResultSet keys = null;
        
        try{
            connection = this.datasource.getConnection();
            insertStatement = connection.prepareStatement(this.orm.prepareInsert(), Statement.RETURN_GENERATED_KEYS);
            
            insertStatement.setInt(1, domain.getId());
            insertStatement.setString(2, domain.getName());
            insertStatement.setString(3, domain.getLanguage().getName());
            insertStatement.setString(4, domain.getServer().getName());
            insertStatement.setInt(5, domain.getRps_8());
            insertStatement.setInt(6, domain.getRps_16());
            insertStatement.setInt(7, domain.getRps_32());
            insertStatement.setInt(8, domain.getRps_64());
            insertStatement.setInt(9, domain.getRps_128());
            insertStatement.setInt(10, domain.getRps_256());
            insertStatement.setInt(11, domain.getErrors());
            
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

    @Override
    public Framework update(Framework domain) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public List<Framework> eagerReadLanguage(String language)
    {
        Connection connection = null;
        List<Framework> frameworksByParam = new ArrayList<>();
        PreparedStatement readStatement = null;
        ResultSet results = null;
        
        try{
            
            connection = datasource.getConnection();
            readStatement = connection.prepareStatement(this.orm.prepareEagerRead("Languages") +
                    "Frameworks.Language = Languages.Name");
            
            results = readStatement.executeQuery();
            
            while(results.next())
            {
                Framework framework = this.orm.eagerMap(results);
                frameworksByParam.add(framework);
            }
            
            return frameworksByParam;
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{closeAll(readStatement, connection);}
       
        return frameworksByParam;
            
    }
    

}
