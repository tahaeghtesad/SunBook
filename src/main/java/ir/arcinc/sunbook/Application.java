package ir.arcinc.sunbook;

import ir.arcinc.sunbook.datamodel.User;
import ir.arcinc.sunbook.repository.UserDao;
import ir.arcinc.sunbook.repository.UserDaoImpl;
import ir.arcinc.sunbook.service.UserService;
import ir.arcinc.sunbook.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * Created by tahae on 5/20/2016.
 */
@SpringBootApplication
public class Application{

    public static void main(String[] args){
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        String[] beans = ctx.getBeanDefinitionNames();
        Arrays.sort(beans);
        for(String bean : beans)
            System.out.println(bean);

        System.out.println(
                "   _____             ____              __  \n" +
                "  / ___/__  ______  / __ )____  ____  / /__\n" +
                "  \\__ \\/ / / / __ \\/ __  / __ \\/ __ \\/ //_/\n" +
                " ___/ / /_/ / / / / /_/ / /_/ / /_/ / ,<   \n" +
                "/____/\\__,_/_/ /_/_____/\\____/\\____/_/|_|  \n" +
                "                                           "
        );
    }
}