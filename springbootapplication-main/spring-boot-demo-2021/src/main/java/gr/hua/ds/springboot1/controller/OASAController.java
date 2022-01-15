package gr.hua.ds.springboot1.controller;

import gr.hua.ds.springboot1.entity.Application;
import gr.hua.ds.springboot1.service.ApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/oasa")
public class OASAController {

    private final ApplicationService applicationService;

    private Application tempAppl;

    public OASAController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }


    @GetMapping("/validation")
    public ModelAndView doValidation(Model model) {
        tempAppl = null;
        if (applicationService.getApplicationsforOASA().size() != 0)
            tempAppl = applicationService.getApplicationsforOASA().get(0);

        model.addAttribute("allapl", tempAppl);
        model.addAttribute("appl", new Application());
        return new ModelAndView("validation-page");
    }

    @GetMapping("/validation/done")
    public ModelAndView successValidation(Model model) {
        if (tempAppl != null) {
            tempAppl.setApplicationstatus(2);
            applicationService.saveApplication(tempAppl);
        }
        return new ModelAndView("validateform-page");
    }

}
