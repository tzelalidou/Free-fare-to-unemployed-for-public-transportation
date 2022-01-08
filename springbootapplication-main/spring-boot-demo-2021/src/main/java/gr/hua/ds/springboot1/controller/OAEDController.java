package gr.hua.ds.springboot1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/oaed")
public class OAEDController {

    @GetMapping("/confirmation")
    public ModelAndView doConfirm() {
        return new ModelAndView("confirmation-page");
    }
}