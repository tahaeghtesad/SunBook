package ir.arcinc.sunbook.repository;

import ir.arcinc.sunbook.datamodel.AbstractPost;
import ir.arcinc.sunbook.datamodel.Comment;
import ir.arcinc.sunbook.datamodel.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

/**
 * Created by tahae on 5/30/2016.
 */
@Repository
@Transactional
public class CommentDaoImpl implements CommentDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Collection<Comment> getCommentsForPost(AbstractPost post, int page, int count) {
        return em.createQuery("SELECT c FROM Comment c WHERE c.post=:post",Comment.class)
                .setParameter("post",post)
                .setFirstResult(page*count)
                .setMaxResults(count)
                .getResultList();
    }

    @Override
    public boolean comment(User u, AbstractPost p, Comment c) {
        create(c);
        return true;
    }

    @Override
    public boolean like(User u, Comment c) {
        Comment fetchedComment = find(c.getId());
        if (fetchedComment == null)
            return false;
        if (fetchedComment.getLikes().contains(u))
            return false;
        fetchedComment.getLikes().add(u);
        update(fetchedComment);
        return true;
    }

    @Override
    public Comment create(Comment o) {
        em.persist(o);
        em.flush();
        return o;
    }

    @Override
    public Comment find(Long id) {
        return em.find(Comment.class,id);
    }

    @Override
    public void update(Comment o) {
        em.persist(o);
        em.flush();
    }

    @Override
    public void delete(Comment o) {
        em.remove(o);
        em.flush();
    }
}
