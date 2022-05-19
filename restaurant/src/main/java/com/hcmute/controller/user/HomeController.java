package com.hcmute.controller.user;

import com.hcmute.model.AccountModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class HomeController {

    @RequestMapping(value= {"/","/trang-chu"})
    public String index(ModelMap model){
        model.addAttribute("message", "Spring MVC XML Config Example");
        return "home";
    }

}