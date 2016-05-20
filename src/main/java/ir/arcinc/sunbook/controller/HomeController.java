package ir.arcinc.sunbook.controller;

import org.springframework.boot.autoconfigure.web.WebMvcProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by tahae on 5/20/2016.
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView index = new ModelAndView("home/index");
        return index;
    }

    @RequestMapping("/about")
    @ResponseBody
    public String about(){
        return "about us";
    }
}
