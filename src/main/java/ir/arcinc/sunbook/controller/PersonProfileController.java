package ir.arcinc.sunbook.controller;

import ir.arcinc.sunbook.datamodel.*;
import ir.arcinc.sunbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * Created by Zohreh on 5/30/2016.
 */
@Controller
@RequestMapping("/")
public class PersonProfileController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/pProfile" , method = RequestMethod.GET)
    public ModelAndView pProfilePage(){
        User user = userService.find(2L);
        ModelAndView pProfilePage = new ModelAndView("/PersonProfile/pProfile" , "user" , user);
        return pProfilePage;
    }
}
