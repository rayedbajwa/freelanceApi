package com.letme;

import com.letme.Tasks.services.TaskService;
import com.letme.Users.controller.UsersInfoController;

import com.letme.Tasks.repo.TasksRepo;
import com.letme.Users.repo.UsersInfoRepo;

import com.letme.Users.services.UsersInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.inject.Inject;

@EnableAutoConfiguration
@SpringBootApplication
@EnableConfigurationProperties({LiquibaseProperties.class })
public abstract class LetmeApplication implements TasksRepo{
	private static final Logger log = LoggerFactory.getLogger(UsersInfoController.class);

	@Inject
	private UsersInfoService userService;

	public static void main(String[] args) {
		SpringApplication.run(LetmeApplication.class, args);
	}

	    @Bean
		public CommandLineRunner demo(UsersInfoRepo repository) {
			return (args) -> {
				// save a couple of customers


				// fetch all customers
				log.info("Customers found with findAll():");
				log.info("-------------------------------");

				log.info("");
			};
		}

}
