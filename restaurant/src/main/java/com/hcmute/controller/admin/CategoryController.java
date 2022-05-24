package com.hcmute.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/danh-muc")
public class CategoryController {
    @RequestMapping("/")
    public ModelAndView Index(){
        ModelAndView mav = new ModelAndView("admin/category");
        return mav;
    }
}
