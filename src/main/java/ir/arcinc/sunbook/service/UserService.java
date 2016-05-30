package ir.arcinc.sunbook.service;

import ir.arcinc.sunbook.datamodel.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by tahae on 5/21/2016.
 */
public interface UserService extends GenericService<User,Long>, UserDetailsService {
}
