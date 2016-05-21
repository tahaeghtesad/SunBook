package ir.arcinc.sunbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by tahae on 5/21/2016.
 */
@EnableJdbcHttpSession
public class SpringHTTPSessionConfig {

    //DataSource From Hibernate DataSource

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

}
