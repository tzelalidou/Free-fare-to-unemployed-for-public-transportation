package gr.hua.ds.springboot1.controller;

import gr.hua.ds.springboot1.entity.User;
import gr.hua.ds.springboot1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static java.awt.SystemColor.window;
import static java.lang.Boolean.FALSE;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public AdminController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/add")
    public ModelAndView addUser(Model model) {
        model.addAttribute("newuser", new User());
        return new ModelAndView("add-page");
    }
    @PostMapping("/add")
    public String createUser(@Validated @ModelAttribute User newuser, Model model){
        model.addAttribute("newuser", newuser);
        newuser.setPassword(passwordEncoder.encode(newuser.getPassword()));
        newuser.setEnabled(1);
        User savedEntitie = userService.saveUser(newuser);
        System.out.println("Entitie id " + savedEntitie.getId());
        return "UserSuccessPage";

    }

    @RequestMapping("/alter")
    public ModelAndView alterUser() {
        return new ModelAndView("alter-page");
    }
    @RequestMapping("/delete")
    public ModelAndView deleteUser() {
        return new ModelAndView("delete-page");
    }


}



