package ir.arcinc.sunbook.repository;

import ir.arcinc.sunbook.datamodel.AbstractPost;
import ir.arcinc.sunbook.datamodel.Comment;
import ir.arcinc.sunbook.datamodel.User;

import java.util.Collection;

/**
 * Created by tahae on 5/30/2016.
 */
public interface CommentDao extends GenericDao<Comment,Long> {
    Collection<Comment> getCommentsForPost(AbstractPost post, int page, int count);
    boolean comment(User u, AbstractPost p, Comment c);
    boolean like (User u, Comment c);
}
