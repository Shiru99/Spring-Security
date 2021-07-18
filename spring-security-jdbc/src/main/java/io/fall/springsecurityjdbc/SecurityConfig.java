package io.fall.springsecurityjdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired              // for embedded (in-memory) database
    DataSource dataSource;  

    // 1. Configure Spring Security Authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        /*  M-1  */  
        // auth.jdbcAuthentication().dataSource(dataSource)
        //     .withDefaultSchema()
        //     .withUser(User.withUsername("admin").password("1234").roles("ADMIN"))
        //     .withUser(User.withUsername("user").password("1234").roles("USER"));

        /*  M-2  */
        // schema - resources/schema.sql & data - resources/data.sql
        auth.jdbcAuthentication().dataSource(dataSource);

        /*  
            by default jdbcAuthentication queries - 

                auth.jdbcAuthentication()
                    .dataSource(dataSource)
                        .usersByUsernameQuery(
                            "select username,password,enabled "+
                            " from users "+
                            " where username=?"
                        )
                        .authoritiesByUsernameQuery(
                            "select username,authority "+
                            " from authorities "+
                            " where username=?"
                        );

            In case of external database we need to configure these default queries
        */

    }


    // 2. Configure Spring Security Authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Order - most restrictive to least restrictive
        http.authorizeRequests()
            .antMatchers("/admin").hasRole("ADMIN")
            .antMatchers("/user").hasAnyRole("USER","ADMIN")
            .antMatchers("/").permitAll()
            .and().formLogin(); // Default form login 
    }

    /*    password encoder : @Bean of type PasswordEncoder    */
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}