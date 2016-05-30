package ir.arcinc.sunbook.service;

import ir.arcinc.sunbook.datamodel.User;
import ir.arcinc.sunbook.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * Created by tahae on 5/21/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User create(User o) {
        return userDao.create(o);
    }

    @Override
    public User find(Long id) {
        return userDao.find(id);
    }

    @Override
    public void update(User o) {
        userDao.update(o);
    }

    @Override
    public void delete(User o) {
        userDao.delete(o);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userDao.getUserByUserName(username);
        if (u==null)
            throw new UsernameNotFoundException("User " + username + " not found.");
        return u;
    }
}
