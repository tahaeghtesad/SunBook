package ir.arcinc.sunbook.controller;

import ir.arcinc.sunbook.datamodel.*;
import ir.arcinc.sunbook.service.CompService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Zohreh on 5/30/2016.
 */

@Controller
@RequestMapping("/")
public class CompanyController {
    @Autowired
    private CompService compService;
    @RequestMapping(value = "/cProfile" , method = RequestMethod.GET)
    public ModelAndView cProfilePage(){
        Set<Project> projects = new HashSet<Project>();
        Set<User> team = new HashSet<User>();
        Company comp = new Company("اسم شرکت2", new HashSet<Adv>(), "سهامی خاص", "تهران", "تهران", "همه کار میکنیم! :دی", "مدیر", projects, team);
        Project project = new Project("پروژه 1" , comp , team , "توضیییییییییییییح");
        Set<Skill> skills = new HashSet<Skill>();
        Skill skill = new Skill("java");
        skills.add(skill);
        User user = new User("علی", "علوی", "Ali Alavi",comp, "alialavi@gmail.com", "pass", "برنامه نویس",  projects , "تهران","تهران","دانشگاه شهید بهشتی" ,"مهندسی کامپیوتر، نرم افزار",skills);
        team.add(user);
        projects.add(project);
        comp.setEmployee(team);
        comp.setProjects(projects);
        ModelAndView cProfilePage = new ModelAndView("/company/cProfile" , "company" , comp);
        return cProfilePage;
    }
}
