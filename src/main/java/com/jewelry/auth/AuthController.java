package com.jewelry.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    Hashing hash = new Hashing();

    @GetMapping("/authentication")
    public String authentication(Model model) {
        model.addAttribute("title", "Auth");
        return "auth";
    }
    @PostMapping("/authentication")
    public String getInfo(@RequestParam String login, @RequestParam String password, Model model) {
        if (login.equals("")||password.equals("")) return "auth";
        Authentication authentication = new Authentication(hash.hash(login + ":" + password));

        if(authentication.findTheSame()) {
            System.out.println("Welcome, " + login);
            return "welcomePage";
        }
        else {
            System.out.println("Failed. Please, try again.");
            return "auth";
        }

    }

}