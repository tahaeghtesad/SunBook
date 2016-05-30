package ir.arcinc.sunbook.repository;

import ir.arcinc.sunbook.datamodel.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by tahae on 5/21/2016.
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User getUserByEmail(String email) {
        String hql = "SELECT u FROM User u WHERE u.email=:email";
        Query query = em.createQuery(hql);
        query.setParameter("email",email);
        return (User) query.getSingleResult();
    }

    @Override
    public User getUserByUserName(String userName){
        String hql = "SELECT u FROM User u WHERE u.username=:userName";
        Query query = em.createQuery(hql);
        query.setParameter("userName",userName);
        List<User> res = (List<User>) query.getResultList();
        return res == null || res.size() == 0 ? null : res.get(0);
    }

    @Override
    @Transactional
    public User create(User o) {
        em.persist(o);
        em.flush();
        return o;
    }

    @Override
    public User find(Long id) {
        return em.find(User.class,id);
    }

    @Override
    @Transactional
    public void update(User o) {
        em.persist(o);
        em.flush();
    }

    @Override
    @Transactional
    public void delete(User o) {
        em.remove(o);
        em.flush();
    }
}
