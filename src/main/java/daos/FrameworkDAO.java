package daos;

import javax.sql.DataSource;

import domain_objects.Framework;
import orms.ORM;

public class FrameworkDAO extends AbstractDAO<Framework>{

    protected FrameworkDAO(DataSource datasource, ORM<Framework> orm) {
        super(datasource, orm);
        // TODO Auto-generated constructor stub
    }

    public void close() throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Framework insert(Framework domain) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Framework update(Framework domain) {
        // TODO Auto-generated method stub
        return null;
    }

}
