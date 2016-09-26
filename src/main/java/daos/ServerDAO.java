package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import domain_objects.Server;
import orms.ORM;

public class ServerDAO extends AbstractDAO<Server>{

    protected ServerDAO(DataSource datasource, ORM<Server> orm) {
        super(datasource, orm);
        // TODO Auto-generated constructor stub
    }

    public void close() throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Server insert(Server domain) {
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

    @Override
    public Server update(Server domain) {
        // TODO Auto-generated method stub
        return null;
    }

}
