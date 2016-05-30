package ir.arcinc.sunbook.config.initializers;

import ir.arcinc.sunbook.config.SpringHTTPSessionConfig;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * Created by tahae on 5/21/2016.
 */
public class SpringSessionInitializer extends AbstractHttpSessionApplicationInitializer {
    public SpringSessionInitializer(){
        super(SpringHTTPSessionConfig.class);
    }
}
