package ir.arcinc.sunbook.controller;

import ir.arcinc.sunbook.datamodel.*;
import ir.arcinc.sunbook.service.AdvService;
import ir.arcinc.sunbook.service.CommentService;
import ir.arcinc.sunbook.service.PostService;
import ir.arcinc.sunbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Date;
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

    @Autowired
    private AdvService advService;

    @RequestMapping("/home")
    public ModelAndView home(){

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
        mav.addObject("user",currentUser);
        return mav;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public boolean createSimplePost(@RequestBody String text){
        //        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userService.find(0L);

        AbstractPost post = new SimplePost(currentUser,new Date(),text);
        try{
            postService.create(post);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @RequestMapping(value = "/like/{postId}",method = RequestMethod.POST)
    public @ResponseBody boolean like(@PathVariable long postId){
        //        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userService.find(0L);

        AbstractPost post = postService.find(postId);

        return postService.like(currentUser,post);
    }

    @RequestMapping(value = "/advertise",method = RequestMethod.POST)
    public @ResponseBody boolean advertise(@ModelAttribute Adv adv){
        return true;
    }
}
