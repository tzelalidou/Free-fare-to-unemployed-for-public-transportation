package gr.hua.ds.springboot1.controller;

import gr.hua.ds.springboot1.entity.Application;
import gr.hua.ds.springboot1.entity.User;
import gr.hua.ds.springboot1.service.ApplicationService;
import gr.hua.ds.springboot1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/oaed")
public class OAEDController {

    private final ApplicationService applicationService;

    public OAEDController( ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/confirmation")
    public ModelAndView seeAllAppl(Model model) {
        model.addAttribute("allapl",applicationService.getApplicationsforOAED());
        model.addAttribute("appl", new Application());
        return new ModelAndView("confirmation-page");
    }
    @PostMapping("/confirmation")
    public ModelAndView ChooseAppl(@Validated @ModelAttribute Application app, Model model){
        Application app1=applicationService.getApplicationforOAED(app.getAid());
        
        model.addAttribute("app", app1);
        applicationService.AddAppTemp(app1);
        System.out.println(applicationService.getTemp().get(0).getAid());
        System.out.println(applicationService.getTemp().get(0).getAmkanumber());
        model.addAttribute("applica",applicationService.getTemp());
        return new ModelAndView("OAEDregectaccept");

    }

}