package gr.hua.ds.springboot1.controller;
import gr.hua.ds.springboot1.entity.Application;
import gr.hua.ds.springboot1.entity.User;
import gr.hua.ds.springboot1.service.ApplicationService;
import gr.hua.ds.springboot1.service.UserService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Locale;

@RestController
@RequestMapping("/unemployed")
public class UnemployedController {
    private final String UPLOAD_DIR = "C:\\temp\\";
    private UserService userService;
    private ApplicationService applicationService;

    public UnemployedController(UserService userService, ApplicationService applicationService) {
        this.userService = userService;
        this.applicationService = applicationService;
    }

    // get the user input from the form into an application object in the model
    @GetMapping("/application")
    public ModelAndView seeForm(Model model) {
        try {
            Application appl = new Application();
            model.addAttribute("appl", appl);
        } catch (Exception e){
            return new ModelAndView("error-page");
        }

        return new ModelAndView("applicationform-page");
    }

    @PostMapping("/application")
    public ModelAndView seeResults(@RequestParam("avatar") MultipartFile file,@ModelAttribute("appl") Application appl) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            appl.setUser(userService.getUnemployedUserByUsername(currentPrincipalName));
            appl.setApplicationstatus(0);
            appl.setImgname("img"+Long.toString(appl.getAmkanumber()).hashCode()+".jpg");

            // save image in local file
            Path currentPath = Paths.get("");
            Path absPath = currentPath.toAbsolutePath();
            Path path = Paths.get(absPath + "\\springbootapplication-main\\spring-boot-demo-2021\\src\\main\\resources\\img\\"+appl.getImgname());
            Files.copy(file.getInputStream(), path);
            //add in list of applications of user the current application(appl)
            userService.getUnemployedUserByUsername(currentPrincipalName).addInApplications(appl);
            //appl.setImgname("img"+currentPrincipalName.hashCode()+appl.getAmkanumber().hashCode());
            // save to server.
            applicationService.saveApplication(appl);
            userService.saveUser(userService.getUnemployedUserByUsername(currentPrincipalName));
        } catch (Exception e){
            return new ModelAndView("error-page");
        }
        return new ModelAndView("UserSuccessPage");
    }


    @GetMapping("/myapplications")
    public ModelAndView showApplications(Model model) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            model.addAttribute("allapl", applicationService.getApplicationsUnemployed(username));
        } catch (Exception e){
            return new ModelAndView("error-page");
        }
        return new ModelAndView("myapplications-page");
    }
    @GetMapping("/deleteAccount")
    public ModelAndView deleteAccount(@ModelAttribute User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        try {
            User currentUser=userService.getUserByUsername(currentUserName);
            userService.removeUser(currentUser);
        } catch (Exception e){
            return new ModelAndView("error-page");
        }
        return new ModelAndView("api-page");
    }

}

