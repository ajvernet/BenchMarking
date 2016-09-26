package daos;


    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;

    import javax.sql.DataSource;

    import domain_objects.DomainObject;
    import orms.ORM;

 

    public abstract class AbstractDAO<T extends DomainObject> implements AutoCloseable
    {
        final DataSource datasource;
        final ORM<T> orm;
        
        protected AbstractDAO(DataSource datasource, ORM<T> orm)
        {
            this.datasource = datasource;
            this.orm = orm;
        }

        public abstract T insert(T domain);
        
        public boolean delete(int id)
        {
      
            try {
                Connection connection = this.datasource.getConnection();
                PreparedStatement deleteStatement = connection.prepareStatement
                        (this.orm.prepareDelete());
                deleteStatement.setInt(1, id);
                
                int numDelete = deleteStatement.executeUpdate();
                closeAll(deleteStatement, connection);
                
                if(numDelete > 0) return true;
               
        
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            return false;
        }
        public abstract T update(T domain);
        
        public int clear() throws UnsupportedOperationException
        {
            Connection conn = null;
            Statement clear = null;
            try
            {
               conn = this.datasource.getConnection();
               clear = conn.createStatement();
               return clear.executeUpdate("DELETE FROM " + this.orm.table() + ";");
            }
            catch (Exception ex)
            {

            }
            finally 
            {
                closeAll(clear, conn);
            }
            return 0;
        }    
        
        public T read(int id)
        {
            try
            {
                Connection connection = this.datasource.getConnection();
                PreparedStatement read = connection.prepareStatement(this.orm.prepareRead());
                read.setInt(1, id);
                ResultSet query = read.executeQuery();
                if (query.next())

                    return this.orm.map(query);

            }
            catch (Exception ex)
            {

            }
            return null;
        }
        
        static protected void closeAll(ResultSet results, Statement statement, Connection connection)
        {
            closeAll(results);
            closeAll(statement, connection);

        }
      static protected void closeAll(Statement statement, Connection connection)
      {
        closeAll(statement);
        closeAll(connection);
      }
      
      static protected void closeAll(AutoCloseable closeable)
      {
         
              if(closeable != null)
                try {
                    closeable.close();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
          
      }

}


