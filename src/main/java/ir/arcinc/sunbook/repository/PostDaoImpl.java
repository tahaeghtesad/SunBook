package ir.arcinc.sunbook.repository;

import ir.arcinc.sunbook.datamodel.AbstractPost;
import ir.arcinc.sunbook.datamodel.SimplePost;
import ir.arcinc.sunbook.datamodel.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;

/**
 * Created by tahae on 5/30/2016.
 */
@Repository
@Transactional
public class PostDaoImpl implements PostDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Collection<AbstractPost> getLatestPostsForUser(User user, int page, int count) {
//        String hql = "SELECT p FROM SimplePost p WHERE p.poster IN (SELECT u FROM User u WHERE u=:u) OR p.poster=:u ORDER BY p.creationDate";
        String hql = "SELECT p FROM SimplePost p";
        Query q = em.createQuery(hql,SimplePost.class)
//                .setParameter("u",user)
                .setFirstResult(count * page)
                .setMaxResults(count);
        Collection<AbstractPost> res = q.getResultList();
        assert res.size() <= count;
        return res;
    }

    @Override
    public Collection<AbstractPost> getUserPosts(User user, int page, int count) {
        String hql = "SELECT p FROM SimplePost p WHERE p.poster=:poster ORDER BY p.creationDate";
//        String hql = "SELECT p FROM SimplePost p";
        Query q = em.createQuery(hql,SimplePost.class)
                .setParameter("poster",user)
                .setFirstResult(count * page)
                .setMaxResults(count);
        Collection<AbstractPost> results = q.getResultList();
        assert results.size() <= count;
        return results;
    }

    @Override
    public boolean like(User u, AbstractPost p) {
        AbstractPost fetchedPost = find(p.getId());
        if (fetchedPost == null)
            return false;
        if (fetchedPost.getLikes().contains(u))
            return false;
        fetchedPost.getLikes().add(u);
        update(fetchedPost);
        return true;
    }

    @Override
    public AbstractPost create(AbstractPost o) {
        em.persist(o);
        return o;
    }

    @Override
    public AbstractPost find(Long id) {
        return em.find(SimplePost.class,id);
    }

    @Override
    public void update(AbstractPost o) {
        em.persist(o);
        em.flush();
    }

    @Override
    public void delete(AbstractPost o) {
        em.remove(o);
        em.flush();
    }
}
