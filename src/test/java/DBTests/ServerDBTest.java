package DBTests;
import static org.junit.Assert.*;

import java.util.Objects;

import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import daos.ServerDAO;
import domain_objects.Server;
import orms.ServerORM;

public class ServerDBTest {

    
    static String URL = "jdbc:mysql://localhost/benchmarks?" + 
            "user=root&password=root" + 
        "&useServerPrepStmts=true";
    
    MysqlDataSource datasource;
    ServerORM serverORM = new ServerORM(){};
    ServerDAO serverDAO;
    
    @Before
    public void setup()
    {
        datasource = new MysqlDataSource();
        datasource.setURL(URL);
        serverDAO = new ServerDAO(datasource, serverORM);
        serverDAO.clear();
    }
    
    @Test
    public void insertTest() {
        Server testLang1 = new Server("Java");
        testLang1 = serverDAO.insert(testLang1);
        assertTrue(Objects.nonNull(serverDAO.read(testLang1.getId())));
    }
    
    @Test
    public void deleteTest()
    {
        Server testLang1 = new Server("Java");
        testLang1 = serverDAO.insert(testLang1);
        serverDAO.delete(testLang1.getId());
        assertFalse(Objects.nonNull(serverDAO.read(testLang1.getId())));
    }
    

}

