package com.letme.Config;

import liquibase.integration.spring.SpringLiquibase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import javax.sql.DataSource;


/**
 * Created by mbajwa11 on 12/23/16.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.letme.*.repo")
public class DBConfig  {
    private final static Logger LOGGER = LoggerFactory.getLogger(DBConfig.class);

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String pass;

    @Primary
    @Bean(name = "mainDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.main")
    public DataSourceProperties dataSourceProperties(){
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name="mainDataSource", destroyMethod = "close")
    @Qualifier("mainDataSourceProperties")
    public HikariDataSource dataSource(@Qualifier("mainDataSourceProperties") DataSourceProperties dataSourceProperties){
        LOGGER.debug("Configuration Datasource {} {} ", url, user);
        HikariDataSource hikariDataSource =  (HikariDataSource) DataSourceBuilder
                .create(dataSourceProperties.getClassLoader())
                .type(HikariDataSource.class)
                .driverClassName(dataSourceProperties.getDriverClassName())
                .url(dataSourceProperties.getUrl())
                .username(dataSourceProperties.getUsername())
                .password(dataSourceProperties.getPassword())
                .build();
        return hikariDataSource;
    }
    @Bean
    public SpringLiquibase liquibase(@Qualifier("mainDataSource") DataSource dataSource, DataSourceProperties dataSourceProperties,
                                            LiquibaseProperties liquibaseProperties) {

        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:liquibase/master.xml");
        liquibase.setContexts(liquibaseProperties.getContexts());
        liquibase.setDefaultSchema(liquibaseProperties.getDefaultSchema());
        liquibase.setDropFirst(liquibaseProperties.isDropFirst());
        return liquibase;
    }
}
