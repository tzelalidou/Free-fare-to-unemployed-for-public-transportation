package gr.hua.ds.springboot1.controller;

import gr.hua.ds.springboot1.entity.User;
import gr.hua.ds.springboot1.service.UserService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView createUser(@Validated @ModelAttribute User newuser, Model model){
        model.addAttribute("newuser", newuser);
        newuser.setPassword(passwordEncoder.encode(newuser.getPassword()));
        newuser.setEnabled(1);
        User savedEntitie = userService.saveUser(newuser);
        System.out.println("Entitie id " + savedEntitie.getId());
        return new ModelAndView("UserSuccessPage");

    }

    @RequestMapping("/alter")
    public ModelAndView alterUser() {
        return new ModelAndView("alter-page");
    }

    @GetMapping("/delete")
    public ModelAndView seeDeleteUser(Model model) {
        model.addAttribute("allusers",userService.getUsersExceptUnemployed());
        model.addAttribute("deluser", new User());
        return new ModelAndView("delete-page");
    }
    @PostMapping("/delete")
    public ModelAndView  deleteUser( @ModelAttribute User deluser) {

        userService.removeUserById(deluser.getId());
        System.out.println("deleted");

        return new ModelAndView("UserSuccessPage");

    }


}



