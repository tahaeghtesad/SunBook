package ir.arcinc.sunbook.service;

import ir.arcinc.sunbook.datamodel.AbstractPost;
import ir.arcinc.sunbook.datamodel.SimplePost;
import ir.arcinc.sunbook.datamodel.User;

import java.util.Collection;

/**
 * Created by tahae on 5/30/2016.
 */
public interface PostService extends GenericService<AbstractPost,Long> {
    Collection<AbstractPost> getLatestPostsForUser(User user, int page, int count);
    Collection<AbstractPost> getLatestPostsForUser(User user);
    Collection<AbstractPost> getUserPosts(User user, int page, int count);
    Collection<AbstractPost> getUserPosts(User user);
    boolean like (User u, AbstractPost p);
}
