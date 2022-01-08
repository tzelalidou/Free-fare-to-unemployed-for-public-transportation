package gr.hua.ds.springboot1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/add")
    public ModelAndView addUser() {return new ModelAndView("add-page");}
    @RequestMapping("/alter")
    public ModelAndView alterUser() {
        return new ModelAndView("alter-page");
    }
    @RequestMapping("/delete")
    public ModelAndView deleteUser() {
        return new ModelAndView("delete-page");
    }
}
