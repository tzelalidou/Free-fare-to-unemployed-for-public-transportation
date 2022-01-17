package gr.hua.ds.springboot1.controller;

import gr.hua.ds.springboot1.config.WebSecurityConfig;
import gr.hua.ds.springboot1.entity.User;
import gr.hua.ds.springboot1.repository.UserRepository;
import gr.hua.ds.springboot1.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
    private UserService userService;

    private final WebSecurityConfig encodepass;

    public HomeController(WebSecurityConfig encodepass, UserService userService) {
        this.encodepass = encodepass;
        this.userService=userService;
    }

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
    @RequestMapping("/home")
    public ModelAndView homepage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User currentUser=userService.getUserByUsername(currentUserName);
        String role=currentUser.getAuthority();
        if(role.equals("ROLE_UNEMPLOYED")){
            return new ModelAndView("unemployed-page");
        }else{
            if(role.equals("ROLE_OAED")){
                return new ModelAndView("oaed-page");
            }
            else{
                if(role.equals("ROLE_OASA")){
                    return new ModelAndView("oasa-page");
                }
                else{
                    return new ModelAndView("admin-page");
                }
            }
        }
    }
    @GetMapping("/register")
    public ModelAndView register(Model model) {
        model.addAttribute("user",new User());
        return new ModelAndView("register-page");
    }

    @PostMapping("/register")
    public ModelAndView postRegister(@ModelAttribute User user) {
        user.setAuthority("ROLE_UNEMPLOYED");
        user.setEnabled(1);
        user.setEmail("-");
        user.setPassword(encodepass.passwordEncoder().encode(user.getPassword()));
        userService.saveUser(user);
        return new ModelAndView("UserSuccessPage");
    }




}
