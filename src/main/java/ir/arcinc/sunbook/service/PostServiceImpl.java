package ir.arcinc.sunbook.service;

import ir.arcinc.sunbook.datamodel.AbstractPost;
import ir.arcinc.sunbook.datamodel.SimplePost;
import ir.arcinc.sunbook.datamodel.User;
import ir.arcinc.sunbook.repository.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by tahae on 5/30/2016.
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    public Collection<AbstractPost> getLatestPostsForUser(User user, int page, int count) {
        return postDao.getLatestPostsForUser(user,page,count);
    }

    @Override
    public Collection<AbstractPost> getLatestPostsForUser(User user) {
        return this.getLatestPostsForUser(user,0,20);
    }

    @Override
    public Collection<AbstractPost> getUserPosts(User user, int page, int count) {
        return postDao.getUserPosts(user,page,count);
    }

    @Override
    public Collection<AbstractPost> getUserPosts(User user) {
        return this.getUserPosts(user,0,20);
    }

    @Override
    public boolean like(User u, AbstractPost p) {
        return postDao.like(u,p);
    }

    @Override
    public AbstractPost create(AbstractPost o) {
        return postDao.create(o);
    }

    @Override
    public AbstractPost find(Long id) {
        return postDao.find(id);
    }

    @Override
    public void update(AbstractPost o) {
        postDao.update(o);
    }

    @Override
    public void delete(AbstractPost o) {
        postDao.delete(o);
    }
}
