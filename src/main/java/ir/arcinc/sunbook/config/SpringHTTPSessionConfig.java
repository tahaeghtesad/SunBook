package ir.arcinc.sunbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

/**
 * Created by tahae on 5/21/2016.
 */
@Configuration
@EnableJdbcHttpSession
public class SpringHTTPSessionConfig {

    //DataSource From Hibernate DataSource

}
