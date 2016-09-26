package DBTests;
import static org.junit.Assert.*;

import java.util.Objects;

import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import daos.LanguageDAO;
import domain_objects.Language;
import domain_objects.Language;
import orms.LanguageORM;

public class LanguageDBTest {

    static String URL = "jdbc:mysql://localhost/benchmarks?" + 
            "user=root&password=root" + 
        "&useLanguagePrepStmts=true";
    
    MysqlDataSource datasource;
    LanguageORM langORM = new LanguageORM(){};
    LanguageDAO langDAO;
    
    @Before
    public void setup()
    {
        datasource = new MysqlDataSource();
        datasource.setURL(URL);
        langDAO = new LanguageDAO(datasource, langORM);
        langDAO.clear();
    }
    @Test
    public void insertTest() {
        Language testLang1 = new Language("Java");
        testLang1 = langDAO.insert(testLang1);
        assertTrue(Objects.nonNull(langDAO.read(testLang1.getId())));
    }
    
    @Test
    public void deleteTest()
    {
        Language testLang1 = new Language("Java");
        testLang1 = langDAO.insert(testLang1);
        langDAO.delete(testLang1.getId());
        assertFalse(Objects.nonNull(langDAO.read(testLang1.getId())));
    }

}
