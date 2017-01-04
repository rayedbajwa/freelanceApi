package com.letme.Config;


import io.swagger.annotations.Contact;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by mbajwa11 on 1/4/17.
 */

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-04T14:32:17.238Z")

@Configuration
public class SwaggerConfig {
    @Value("${springfox.documentation.swagger.v2.path}")
    private String swagger2Endpoint;
    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Freelance API")
                .description("Move your app forward with the Freelance API")
                .license("")
                .licenseUrl("")
                .termsOfServiceUrl("")
                .version("1.0.0")
                .contact("Rayed Bajwa")
                .build();
    }
    @Bean
    public Docket swaggerSettings() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .pathMapping("/docs")
                .enableUrlTemplating(true);
    }
}
