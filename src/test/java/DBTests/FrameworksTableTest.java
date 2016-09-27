package DBTests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Objects;

import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import daos.FrameworkDAO;
import daos.LanguageDAO;
import daos.ServerDAO;
import domain_objects.Framework;
import domain_objects.Language;
import domain_objects.Server;
import orms.FrameworkORM;
import orms.LanguageORM;
import orms.ServerORM;

public class FrameworksTableTest {

    static String URL = "jdbc:mysql://localhost/benchmarks?" + 
            "user=root&password=root" + 
        "&useFrameworkPrepStmts=true";
    
    MysqlDataSource datasource;
    FrameworkORM frameORM = new FrameworkORM(){};
    FrameworkDAO frameDAO;
    
    ServerORM serverORM = new ServerORM(){};
    ServerDAO serverDAO;
    
    LanguageORM langORM = new LanguageORM(){};
    LanguageDAO langDAO;
    
    @Before
    public void setup()
    {
        datasource = new MysqlDataSource();
        datasource.setURL(URL);
        frameDAO = new FrameworkDAO(datasource, frameORM);
        frameDAO.clear();
        
        serverDAO = new ServerDAO(datasource, serverORM);
        serverDAO.clear();
        
        langDAO = new LanguageDAO(datasource, langORM);
        langDAO.clear();
        }
    //@Test
    public void insertTest() {

        Language testLang1 = new Language("Java");
        testLang1 = langDAO.insert(testLang1);
        
        Server testServer1 = new Server("Resin");
        testServer1 = serverDAO.insert(testServer1);
        
        Framework testFrame1 = new Framework("testFrame1", new Language("Java"), new Server("Resin"), 0, 0, 0, 0, 0, 0, 0);
        testFrame1 = frameDAO.insert(testFrame1);
        assertTrue(Objects.nonNull(frameDAO.read(testFrame1.getId())));
    }
    
    @Test
    public void deleteTest()
    {
        Framework testFrame1 = new Framework(0, "testFrame1", new Language("Java"), new Server("Resin"), 0, 0, 0, 0, 0, 0, 0);
        testFrame1 = frameDAO.insert(testFrame1);
        frameDAO.delete(testFrame1.getId());
        assertFalse(Objects.nonNull(frameDAO.read(testFrame1.getId())));
    }
    
    @Test
    public void joinOnLanguageTest()
    {
        Language testLang1 = new Language("Java");
        testLang1 = langDAO.insert(testLang1);
        
        Language testLang2 = new Language("Python");
        testLang1 = langDAO.insert(testLang2);
        
        Server testServer1 = new Server("Resin");
        testServer1 = serverDAO.insert(testServer1);
        
        Framework testFrame1 = new Framework("testFrame1", new Language("Java"), new Server("Resin"), 0, 0, 0, 0, 0, 0, 0);
        testFrame1 = frameDAO.insert(testFrame1);
        
        Framework testFrame2 = new Framework("testFrame2", new Language("Java"), new Server("Resin"), 0, 0, 0, 0, 0, 0, 0);
        testFrame1 = frameDAO.insert(testFrame2);
        
        Framework testFrame3 = new Framework("testFrame3", new Language("Java"), new Server("Resin"), 0, 0, 0, 0, 0, 0, 0);
        testFrame1 = frameDAO.insert(testFrame3);
        
        List<Framework> testFrameList1 = frameDAO.eagerReadLanguage("Java");
        assertTrue(testFrameList1.size() == 3);

    }
    
    @Test
    public void joinOnServerTest()
    {
        Language testLang1 = new Language("Java");
        testLang1 = langDAO.insert(testLang1);
        
        Language testLang2 = new Language("Python");
        testLang1 = langDAO.insert(testLang2);
        
        Server testServer1 = new Server("Resin");
        testServer1 = serverDAO.insert(testServer1);
        
        
        Framework testFrame1 = new Framework("testFrame1", new Language("Java"), new Server("Resin"), 0, 0, 0, 0, 0, 0, 0);
        testFrame1 = frameDAO.insert(testFrame1);
        
        Framework testFrame2 = new Framework("testFrame2", new Language("Python"), new Server("Resin"), 0, 0, 0, 0, 0, 0, 0);
        testFrame1 = frameDAO.insert(testFrame2);
        
        Framework testFrame3 = new Framework("testFrame3", new Language("Java"), new Server("Wicket"), 0, 0, 0, 0, 0, 0, 0);
        testFrame1 = frameDAO.insert(testFrame3);
        
        List<Framework> testFrameList1 = frameDAO.eagerReadServer("Resin");
        assertTrue(testFrameList1.size() == 2);

    }
    

}
