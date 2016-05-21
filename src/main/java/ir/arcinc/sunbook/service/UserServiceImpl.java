package ir.arcinc.sunbook.service;

import ir.arcinc.sunbook.datamodel.User;
import ir.arcinc.sunbook.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * Created by tahae on 5/21/2016.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private HttpSession session;


    @Override
    public boolean logIn(String email, String password) {
        //TODO should validate
        session.setAttribute("username",email);
        return true;
    }

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
}
