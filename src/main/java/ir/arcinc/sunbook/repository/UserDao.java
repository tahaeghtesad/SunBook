package ir.arcinc.sunbook.repository;

import ir.arcinc.sunbook.datamodel.User;

/**
 * Created by tahae on 5/21/2016.
 */
public interface UserDao extends GenericDao<User,Long>{
    User getUserByEmail(String email);
}
