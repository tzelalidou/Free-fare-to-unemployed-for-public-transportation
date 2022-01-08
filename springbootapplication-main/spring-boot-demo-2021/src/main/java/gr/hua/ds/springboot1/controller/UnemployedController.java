package gr.hua.ds.springboot1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/unemployed")
public class UnemployedController {

    @GetMapping("/application")
    public ModelAndView seeForm() {
        return new ModelAndView("applicationform-page");
    }



}
