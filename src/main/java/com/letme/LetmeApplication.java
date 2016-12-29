package com.letme;

import com.letme.Users.controller.UserController;
import com.letme.Users.entity.User;
import com.letme.Users.repo.UserRepo;
import com.letme.Users.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;

@EnableAutoConfiguration
@SpringBootApplication
@EnableConfigurationProperties({LiquibaseProperties.class })
public class LetmeApplication {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Inject
	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(LetmeApplication.class, args);
	}

	    @Bean
		public CommandLineRunner demo(UserRepo repository) {
			return (args) -> {
				// save a couple of customers
				repository.save(new User("raid@gmail.com", "Bauer"));
				repository.save(new User("Chloe@gmail.com", "O'Brian"));
				repository.save(new User("Kim@gmail.com", "Bauer"));
				repository.save(new User("David@gmail.com", "Palmer"));
				repository.save(new User("Michelle@gmail.com", "Dessler"));

				// fetch all customers
				log.info("Customers found with findAll():");
				log.info("-------------------------------");
				log.info("Deleted");
					for(User user: repository.findAll()) {
					log.info(user.toString());
					}
				log.info("");
			};
		}

}
