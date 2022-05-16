package com.hcmute.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    @RequestMapping(path= {"/","/trang-chu"})
    public String index(ModelMap model){
        model.addAttribute("message", "Spring MVC XML Config Example");
        return "home";
    }

}