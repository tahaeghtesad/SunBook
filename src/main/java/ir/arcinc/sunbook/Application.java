package ir.arcinc.sunbook;
import ir.arcinc.sunbook.datamodel.*;
import ir.arcinc.sunbook.service.AdvService;
import ir.arcinc.sunbook.service.PostService;
import ir.arcinc.sunbook.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tahae on 5/20/2016.
 */
@SpringBootApplication
public class Application{

    public static void main(String[] args) throws SQLException {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        String[] beans = ctx.getBeanDefinitionNames();
        Arrays.sort(beans);
        for(int i = 0; i < beans.length; i++)
            System.out.println(i+1 + ") " + beans[i]);

        System.out.println(
                "   _____             ____              __  \n" +
                "  / ___/__  ______  / __ )____  ____  / /__\n" +
                "  \\__ \\/ / / / __ \\/ __  / __ \\/ __ \\/ //_/\n" +
                " ___/ / /_/ / / / / /_/ / /_/ / /_/ / ,<   \n" +
                "/____/\\__,_/_/ /_/_____/\\____/\\____/_/|_|  \n" +
                "                                           "
        );

        /*ctx.getBean(DataSource.class).getConnection().createStatement().execute(
                "CREATE TABLE SPRING_SESSION (\n" +
                "\tSESSION_ID CHAR(36),\n" +
                "\tCREATION_TIME BIGINT NOT NULL,\n" +
                "\tLAST_ACCESS_TIME BIGINT NOT NULL,\n" +
                "\tMAX_INACTIVE_INTERVAL INT NOT NULL,\n" +
                "\tPRINCIPAL_NAME VARCHAR(100),\n" +
                "\tCONSTRAINT SPRING_SESSION_PK PRIMARY KEY (SESSION_ID)\n" +
                ");\n" +
                "\n" +
                "CREATE INDEX SPRING_SESSION_IX1 ON SPRING_SESSION (LAST_ACCESS_TIME);\n" +
                "\n" +
                "CREATE TABLE SPRING_SESSION_ATTRIBUTES (\n" +
                "\tSESSION_ID CHAR(36),\n" +
                "\tATTRIBUTE_NAME VARCHAR(200),\n" +
                "\tATTRIBUTE_BYTES LONGVARBINARY,\n" +
                "\tCONSTRAINT SPRING_SESSION_ATTRIBUTES_PK PRIMARY KEY (SESSION_ID, ATTRIBUTE_NAME),\n" +
                "\tCONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_ID) REFERENCES SPRING_SESSION(SESSION_ID) ON DELETE CASCADE\n" +
                ");\n" +
                "\n" +
                "CREATE INDEX SPRING_SESSION_ATTRIBUTES_IX1 ON SPRING_SESSION_ATTRIBUTES (SESSION_ID);\n");*/
        UserService userService = ctx.getBean(UserService.class);
        PostService postService = ctx.getBean(PostService.class);
        AdvService advService = ctx.getBean(AdvService.class);

        Adv adv = new Adv();
        adv.setOstan("tehran");
        adv.setSalaryType(1);
        adv.setType(1);
//        advService.create(adv);


        Set<Project> projects = new HashSet<>();
        Set<User> team = new HashSet<>();
        Set<Skill> skills = new HashSet<>();
        Company comp = new Company("اسم شرکت2", "سهامی خاص", "تهران", "تهران", "همه کار میکنیم! :دی", "مدیر", projects, team);
        Project project = new Project("پروژه 1" , comp , team , "توضیییییییییییییح");
        User u = userService.find(2L);
        AbstractPost p = new SimplePost(u,new Date(),"سلام، برو بمیر");

//        userService.create(u);
//        postService.create(p);
    }
}