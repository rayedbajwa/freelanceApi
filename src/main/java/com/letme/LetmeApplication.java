package com.letme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableAutoConfiguration
@SpringBootApplication
@EnableConfigurationProperties({LiquibaseProperties.class})
public class LetmeApplication {
	public static void main(String[] args) {
		SpringApplication.run(LetmeApplication.class, args);
	}
}
