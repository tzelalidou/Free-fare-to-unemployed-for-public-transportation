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

import javax.persistence.EntityManager;

@RestController
@RequestMapping("/oaed")
public class OAEDController {

    private final ApplicationService applicationService;
    public Application tempApp;

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
        tempApp = app1;
        tempApp.getUser().addInApplications(tempApp);

        System.out.println(tempApp.toString());
        model.addAttribute("applica", app1);
        return new ModelAndView("OAEDregectaccept");
    }

    @GetMapping("/confirmation/accept")
    public ModelAndView acceptAppl() {

        tempApp.setApplicationstatus(1);
        applicationService.saveApplication(tempApp);
        return new ModelAndView("confirmform-page");
    }

    @GetMapping("/confirmation/deny")
    public ModelAndView denyAppl() {

        tempApp.getUser().rmvFromApplications(tempApp);
        //applicationService.removeApplication(tempApp);
        System.out.println(tempApp.getUser().getId());
        System.out.println(tempApp.getUser().getApplications().get(0).toString());
        return new ModelAndView("denyform-page");
    }

}
