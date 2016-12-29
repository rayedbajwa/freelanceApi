package com.letme.Config;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * Created by mbajwa11 on 12/23/16.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"guru.springframework.domain"})
@EnableJpaRepositories(basePackages = {"com.letme.*.repo"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
