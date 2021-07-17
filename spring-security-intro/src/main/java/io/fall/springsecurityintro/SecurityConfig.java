package io.fall.springsecurityintro;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*    password encoder : @Bean of type PasswordEncoder    */
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


    // 1. Configure Spring Security Authentication

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
        auth.inMemoryAuthentication()
            .withUser("admin").password("1234").roles("ADMIN").and()
            .withUser("user").password("1234").roles("USER");
    }

}