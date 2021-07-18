package io.fall.springsecurityjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "io.fall")
public class SpringSecurityWithJpaAuthenticationApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityWithJpaAuthenticationApplication.class, args);
	}
}