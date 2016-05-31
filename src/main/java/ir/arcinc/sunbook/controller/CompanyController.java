package ir.arcinc.sunbook.controller;

import ir.arcinc.sunbook.datamodel.*;
import ir.arcinc.sunbook.service.CompService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Zohreh on 5/30/2016.
 */

@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompService compService;
    @RequestMapping(value = "/profile/{id}" , method = RequestMethod.GET)
    public ModelAndView cProfilePage(@PathVariable long id){
        Company c = compService.find(id);
        return new ModelAndView("company/cProfile" , "company" , c);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ModelAttribute("company")
    public ModelAndView showForm(){
        return new ModelAndView("company/cProfileForm","company",new Company());
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public long submitForm(@ModelAttribute Company c){
        System.out.println(c.getName());
        compService.create(c);
        return c.getId();
    }
}
