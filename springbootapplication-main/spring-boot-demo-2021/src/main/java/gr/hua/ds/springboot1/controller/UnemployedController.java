package gr.hua.ds.springboot1.controller;
import gr.hua.ds.springboot1.entity.Application;
import gr.hua.ds.springboot1.service.ApplicationService;
import gr.hua.ds.springboot1.service.UserService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Locale;

@RestController
@RequestMapping("/unemployed")
public class UnemployedController {

    private UserService userService;
    private ApplicationService applicationService;

    public UnemployedController(UserService userService, ApplicationService applicationService) {
        this.userService = userService;
        this.applicationService = applicationService;
    }

    // get the user input from the form into an application object in the model
    @GetMapping("/application")
    public ModelAndView seeForm(Model model) {
        Application appl = new Application();
        model.addAttribute("appl", appl);
        return new ModelAndView("applicationform-page");
    }

    @PostMapping("/application")
    public ModelAndView seeResults(@ModelAttribute("appl") Application appl) {
        // get User username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        appl.setUser(userService.getUnemployedUserByUsername(currentPrincipalName));
        appl.setApplicationstatus(1);
        appl.setImgname("image");
        //appl.setImgname("img"+currentPrincipalName.hashCode()+appl.getAmkanumber().hashCode());
        // save to server.
        applicationService.saveApplication(appl);

        return new ModelAndView("applicationform-page");
    }

}

