package gr.hua.ds.springboot1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/oasa")
public class OASAController {

    @GetMapping("/validation")
    public ModelAndView doValidation() {
        return new ModelAndView("validation-page");
    }
}