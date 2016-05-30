package ir.arcinc.sunbook;
import ir.arcinc.sunbook.datamodel.Adv;
import ir.arcinc.sunbook.service.AdvService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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
        AdvService service = ctx.getBean(AdvService.class);
        Adv adv = new Adv();
        adv.setOstan("tehran");
        adv.setSalaryType(1);
        adv.setType(1);
        service.create(adv);

        service.find((long) 1);
        System.out.println(adv.getOstan());
    }
}