package ir.arcinc.sunbook.repository;

import ir.arcinc.sunbook.datamodel.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by tahae on 5/21/2016.
 */
public interface UserDao extends GenericDao<User,Long> {
    User getUserByEmail(String email);
    User getUserByUserName(String username);
}
