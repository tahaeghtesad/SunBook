package ir.arcinc.sunbook.service;

import ir.arcinc.sunbook.datamodel.AbstractPost;
import ir.arcinc.sunbook.datamodel.Comment;
import ir.arcinc.sunbook.datamodel.User;

import java.util.Collection;

/**
 * Created by tahae on 5/30/2016.
 */
public interface CommentService extends GenericService<Comment,Long> {
    Collection<Comment> getCommentsForPost(AbstractPost post, int page, int count);
    Collection<Comment> getCommentsForPost(AbstractPost post);
    boolean comment(User u, AbstractPost p, Comment c);
    boolean like (User u, Comment c);
}
