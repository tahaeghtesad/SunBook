package ir.arcinc.sunbook.controller;

import ir.arcinc.sunbook.datamodel.AbstractPost;
import ir.arcinc.sunbook.datamodel.Comment;
import ir.arcinc.sunbook.datamodel.SimplePost;
import ir.arcinc.sunbook.datamodel.User;
import ir.arcinc.sunbook.service.CommentService;
import ir.arcinc.sunbook.service.PostService;
import ir.arcinc.sunbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tahae on 5/30/2016.
 */
@Controller
@RequestMapping("/newsfeed")
public class NewsFeedController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/home")
    private ModelAndView home(){

//        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userService.find(0L);

        ModelAndView mav = new ModelAndView("newsfeed/newsfeed");
        Collection<AbstractPost> posts = postService.getLatestPostsForUser(currentUser);
        mav.addObject("posts",posts);
        Map<AbstractPost,Collection<Comment>> comments = new HashMap<>();
        for (AbstractPost post : posts){
            comments.put(post,commentService.getCommentsForPost(post));
        }
        mav.addObject("comments",comments);
        return mav;
    }
}
