package ir.arcinc.sunbook.servlet3;

import ir.arcinc.sunbook.config.SpringHTTPSessionConfig;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * Created by tahae on 5/21/2016.
 */
public class SessionInitializer extends AbstractHttpSessionApplicationInitializer {
    public SessionInitializer(){
        super(SpringHTTPSessionConfig.class);
    }
}
