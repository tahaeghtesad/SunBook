package ir.arcinc.sunbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by tahae on 5/28/2016.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("account/login");
    }

    @RequestMapping("/error")
    public ModelAndView error(){
        ModelAndView mav = new ModelAndView("account/login");
        mav.addObject("error",true);
        return mav;
    }

}
