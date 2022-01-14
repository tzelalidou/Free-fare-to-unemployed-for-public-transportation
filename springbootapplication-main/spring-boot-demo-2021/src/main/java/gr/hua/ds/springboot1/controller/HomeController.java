package gr.hua.ds.springboot1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

    @GetMapping("/")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    //edw to template gia na dei t application toy
    @RequestMapping("/unemployed")
    public ModelAndView unemployedDashboard() {
        return new ModelAndView("unemployed-page");
    }
    @RequestMapping("/oaed")
    public ModelAndView oaedDashboard() {
        return new ModelAndView("oaed-page");
    }
    @RequestMapping("/oasa")
    public ModelAndView oasaDashboard() {
        return new ModelAndView("oasa-page");
    }
    @RequestMapping("/admin")
    public ModelAndView adminDashboard() {
        return new ModelAndView("admin-page");
    }
    @RequestMapping("/api")
    public ModelAndView hello() {
        return new ModelAndView("api-page");
    }
    @RequestMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register-page");
    }


}
