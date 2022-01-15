package gr.hua.ds.springboot1.controller;

import gr.hua.ds.springboot1.config.WebSecurityConfig;
import gr.hua.ds.springboot1.entity.User;
import gr.hua.ds.springboot1.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
    private final WebSecurityConfig encodepass;
    private final UserRepository userRepository;
    public HomeController(WebSecurityConfig encodepass, UserRepository userRepository) {
        this.encodepass = encodepass;
        this.userRepository = userRepository;
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
        userRepository.save(user);
        return new ModelAndView("register-page");
    }




}
