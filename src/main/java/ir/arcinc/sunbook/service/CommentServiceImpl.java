package ir.arcinc.sunbook.service;

import ir.arcinc.sunbook.datamodel.AbstractPost;
import ir.arcinc.sunbook.datamodel.Comment;
import ir.arcinc.sunbook.datamodel.User;
import ir.arcinc.sunbook.repository.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by tahae on 5/30/2016.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public Collection<Comment> getCommentsForPost(AbstractPost post, int page, int count) {
        return commentDao.getCommentsForPost(post,page,count);
    }

    @Override
    public Collection<Comment> getCommentsForPost(AbstractPost post) {
        return commentDao.getCommentsForPost(post,0,20);
    }

    @Override
    public boolean comment(User u, AbstractPost p, Comment c) {
        return commentDao.comment(u,p,c);
    }

    @Override
    public boolean like(User u, Comment c) {
        return commentDao.like(u,c);
    }

    @Override
    public Comment create(Comment o) {
        return commentDao.create(o);
    }

    @Override
    public Comment find(Long id) {
        return commentDao.find(id);
    }

    @Override
    public void update(Comment o) {
        commentDao.update(o);
    }

    @Override
    public void delete(Comment o) {
        commentDao.delete(o);
    }
}
