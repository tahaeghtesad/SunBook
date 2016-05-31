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
@RequestMapping("/profile")
public class CompanyController {
    @Autowired
    private CompService compService;
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public ModelAndView cProfilePage(@PathVariable long id){
        System.out.print(id);
        Company c = compService.find(id);
        //System.out.print(c.getName());
        System.out.println(c);
        return new ModelAndView("company/cProfile" , "company" , c);
    }

    @RequestMapping(value = "/create/{id}", method = RequestMethod.GET)
    @ModelAttribute("company")
    public ModelAndView showForm(@PathVariable long id){
        Company c = compService.find(id);
        return new ModelAndView("company/cProfileForm","company",c);
    }

    @RequestMapping(value = "/create/{id}",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView submitForm(@ModelAttribute Company c , @PathVariable long id){
        c.setId(id);
   //     compService.update(c);
        System.out.println(c.getName());

        return new ModelAndView("company/cProfile" , "company" , c);
    }
}
