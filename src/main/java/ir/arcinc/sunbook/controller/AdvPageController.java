package ir.arcinc.sunbook.controller;

import ir.arcinc.sunbook.datamodel.Adv;
import ir.arcinc.sunbook.datamodel.Company;
import ir.arcinc.sunbook.datamodel.Project;
import ir.arcinc.sunbook.datamodel.User;
import ir.arcinc.sunbook.repository.AdvDao;
import ir.arcinc.sunbook.service.AdvService;
import ir.arcinc.sunbook.service.AdvServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Zohreh on 5/25/2016.
 */
@Controller
@RequestMapping("/")
public class AdvPageController {
    @Autowired
    private AdvService advService;
    @RequestMapping(value = "/adverP" , method = RequestMethod.GET)
    public ModelAndView advPage(){
        List<Adv> advList = new ArrayList<Adv>();
        Company comp = new Company("اسم شرکت", "سهامی خاص", "تهران", "تهران", "همه کار میکنیم! :دی", "مدیر", new HashSet<Project>(), new HashSet<User>());
        Adv adv1 = new Adv("برنامه نویس جاوا" , comp , "تهران" , new Date(), 1,1,"متن متن متن متن متن");
        adv1.setId((long) 2);
        advList.add(adv1);
        Adv adv2 = new Adv("برنامه نویس جاوا2" , comp , "تهران" , new Date(), 1,1,"متن متن متن متن متن222222");
        adv2.setId((long)3);
        advList.add(adv2);
        ModelAndView advsPage = new ModelAndView("/advPage/adverP" , "list" , advList);
        return advsPage;
    }
    @RequestMapping(value = "/advPage/adv/{id}" , method = RequestMethod.GET)
    public ModelAndView advDetail(@PathVariable long id){
        Adv adv = advService.find(id);
        ModelAndView advPage = new ModelAndView("/advPage/adv" , "Advertise" , adv);
        return advPage;
    }
}
