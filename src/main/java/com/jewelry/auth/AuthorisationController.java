package com.jewelry.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorisationController {

    Hashing hash = new Hashing();

    @GetMapping("/authorisation")
    public String authorisation(Model model){

        return "authorisation";
    }

    @PostMapping("/authorisation")
    public String getInfo(@RequestParam String email,@RequestParam String login, @RequestParam String password, Model model) {
        if (login.equals("")||password.equals("")||email.equals("")) return "authorisation";
        PasswordVerifier passVer = new PasswordVerifier(password);
        if (!passVer.verify()) return "authorisation";

        Authorisation auth = new Authorisation(login);
        String hashedLogin = hash.hash(login);

        if (auth.authorisation()) {
            System.out.println("Email: ");
            String hashedEmail = hash.hash(email);

            if (!auth.isExistsEmail(hashedEmail)) {

                String hashed = hash.hash(login + ":" + password);

                WorkWithFiles.write(hashed, "src\\users.txt");
                WorkWithFiles.write(hashedLogin, "src\\logins.txt");
                WorkWithFiles.write(hashedEmail, "src\\emails.txt");

                System.out.println("Welcome, " + login);
                return "welcomePage";
            } else {
                System.out.println("Account with this email is already exist");
                return "authorisation";
            }
        } else {
            System.out.println("This name is unavailable");
            return "authorisation";
        }
    }
}
