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
        Set<Project> projects = new HashSet<Project>();
        Set<User> team = new HashSet<User>();
        Company comp = new Company("اسم شرکت2", new HashSet<Adv>(), "سهامی خاص", "تهران", "تهران", "همه کار میکنیم! :دی", "مدیر", projects, team);
        Project project = new Project("پروژه 1" , comp , team , "توضیییییییییییییح");
        Set<Skill> skills = new HashSet<Skill>();
        Skill skill = new Skill("java");
        skills.add(skill);
        User user = new User("علی", "علوی","Ali Alavi", comp, "alialavi@gmail.com", "pass", "برنامه نویس",  projects , "تهران","تهران","دانشگاه شهید بهشتی" ,"مهندسی کامپیوتر، نرم افزار",skills);
        team.add(user);
        projects.add(project);
        comp.setEmployee(team);
        comp.setProjects(projects);
        ModelAndView pProfilePage = new ModelAndView("/PersonProfile/pProfile" , "user" , user);
        return pProfilePage;
    }
}
