package gr.hua.ds.springboot1.controller;

import gr.hua.ds.springboot1.entity.Application;
import gr.hua.ds.springboot1.service.ApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@RestController
@RequestMapping("/oasa")
public class OASAController {

    private final ApplicationService applicationService;

    private ArrayList<Application> tempAppl;

    public OASAController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }


    @GetMapping("/validation")
    public ModelAndView doValidation(Model model) {
        try {
            tempAppl = null;
            if (applicationService.getApplicationsforOASA().size() != 0)
                tempAppl = (ArrayList<Application>) applicationService.getApplicationsforOASA();

            model.addAttribute("allapl", tempAppl);
            model.addAttribute("appl", new Application());
        } catch (Exception e){
            return new ModelAndView("error-page");
        }

        return new ModelAndView("validation-page");
    }


    @GetMapping("/validation/done")
    public ModelAndView successValidation(Model model) {
        try {
            for(int i=0;i<tempAppl.size();i++) {
                tempAppl.get(i).setApplicationstatus(2);
                applicationService.saveApplication(tempAppl.get(i));
            }
        } catch (Exception e){
            return new ModelAndView("error-page");
        }

        return new ModelAndView("UserSuccessPage");
    }

}
