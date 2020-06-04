package com.example.bundlesapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.bundlesapi"))
                .paths(regex("/api/v1.*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Bundles API",
                "An API that allows you to query, create, update and delete bundles.",
                "v1",
                "http://localhost:8080/api/v1/bundles/terms",
                new Contact("Angelos Vanakaris", "https://github.com/AVGit97", "angelos.vanakaris@gmail.com"),
                "License of API", "http://localhost:8080/api/v1/bundles/license", Collections.emptyList());
    }

}
