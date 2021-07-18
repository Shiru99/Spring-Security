package io.fall.springsecurityjpa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
    
    @RequestMapping("/")
    public String sayWelcome() {
        return "<h1>Welcome to Spring Security with JDBC</h1>";
    }

    @RequestMapping("/admin")
    public String sayWelcomeAdmin() {
        return "<h1>Welcome to Spring Security with JDBC, Admin</h1>";
    }

    @RequestMapping("/user")
    public String sayWelcomeUser() {
        return "<h1>Welcome to Spring Security with JDBC, User</h1>";
    }
}