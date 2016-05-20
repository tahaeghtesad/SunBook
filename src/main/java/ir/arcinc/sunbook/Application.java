package ir.arcinc.sunbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by tahae on 5/20/2016.
 */
@SpringBootApplication
public class Application{

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
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
