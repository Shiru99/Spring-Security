package io.fall.springsecurityintro;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
    
    @RequestMapping("/")
    public String sayWelcome() {
        return "Welcome to Spring Security Intro";
    }

    @RequestMapping("/admin")
    public String sayWelcomeAdmin() {
        return "Welcome to Spring Security Intro, Admin";
    }

    @RequestMapping("/user")
    public String sayWelcomeUser() {
        return "Welcome to Spring Security Intro, User";
    }
}