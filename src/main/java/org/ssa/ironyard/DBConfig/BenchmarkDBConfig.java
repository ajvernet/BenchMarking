package org.ssa.ironyard.DBConfig;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

@Configuration
public class BenchmarkDBConfig
{
    static final String DATABASE_URL = "jdbc:mysql://localhost/benchmarks?" + "user=root&password=root&" + "useServerPrepStmts=true";
    

    @Bean
    public DataSource datasource()
    {

        MysqlDataSource datasource = new MysqlDataSource();
        datasource.setURL(DATABASE_URL);
        return datasource;
    
    }

}
