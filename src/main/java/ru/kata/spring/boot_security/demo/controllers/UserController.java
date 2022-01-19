package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import java.security.Principal;

@Controller
@RequestMapping("/user")
//@RestController
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("")
    public String returnUser(Principal principal, Model model) {
        model.addAttribute("people", userServiceImpl.findByUsername(principal.getName()));
        return "user";
    }
}


















//    @GetMapping("/")
//    public String homePage () {
//        return "HOME";
//    }
//    @GetMapping("/authentificated")
//    public String pageAuthentificated(Principal principal){
//        return "защищенная область: " + principal.getName();
//    }
//    @GetMapping("/user")
//    public String pageAdmin(Principal principal){
//        User user = userServiceInpl.findByUsername(principal.getName());
//        return "HELLO PAGE USER " + user.getUsername() + " " + user.getLastName() + " " +
//                user.getAge() + "role: " + user.getRoles();
//    }


