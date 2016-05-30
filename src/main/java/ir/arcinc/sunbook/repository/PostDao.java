package ir.arcinc.sunbook.repository;

import ir.arcinc.sunbook.datamodel.AbstractPost;
import ir.arcinc.sunbook.datamodel.SimplePost;
import ir.arcinc.sunbook.datamodel.User;
import ir.arcinc.sunbook.service.GenericService;

import java.util.Collection;

/**
 * Created by tahae on 5/30/2016.
 */
public interface PostDao extends GenericService<AbstractPost,Long> {
    Collection<AbstractPost> getLatestPostsForUser(User user, int page, int count);
    Collection<AbstractPost> getUserPosts(User user, int page, int count);
    boolean like (User u, AbstractPost p);
}
