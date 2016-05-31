package ir.arcinc.sunbook.controller;

import ir.arcinc.sunbook.datamodel.*;
import ir.arcinc.sunbook.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

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
    private AdvService advService;

    @Autowired
    private CompService compService;

    @RequestMapping("/home")
    @ModelAttribute("adv")
    public ModelAndView home(){

//        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userService.find(2L);

        ModelAndView mav = new ModelAndView("newsfeed/newsfeed");
        Collection<AbstractPost> posts = postService.getLatestPostsForUser(currentUser);
        mav.addObject("posts",posts);

        mav.addObject("user",currentUser);
        mav.addObject("adv",new Adv());
        return mav;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public @ResponseBody boolean createSimplePost(@RequestParam String text){
//        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userService.find(2L);
        System.out.println(text);

        AbstractPost post = new SimplePost(currentUser,new Date(),text);
        try{
            postService.create(post);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @RequestMapping(value = "/like/{postId}",method = RequestMethod.GET)
    public @ResponseBody boolean like(@PathVariable long postId) {
//        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userService.find(2L);
        System.out.println(postId);

        AbstractPost post = postService.find(postId);

        return post != null && postService.like(currentUser, post);

    }

    @RequestMapping(value = "/advertise",method = RequestMethod.POST)
    public @ResponseBody boolean advertise(@ModelAttribute Adv adv){
        Company currentCompany = compService.find(0L);
//        Company currentCompany = new Company("ما","1","تهران","تهران","exp","man",Collections.EMPTY_SET,Collections.EMPTY_SET);

//        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userService.find(2L);

        adv.setCompany(currentCompany);
        adv.setDate(new Date());
        adv.setSalaryType(1);

        System.out.println(adv);

        advService.create(adv);

        return true;
    }
}
