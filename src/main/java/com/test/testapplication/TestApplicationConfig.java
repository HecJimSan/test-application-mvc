package com.test.testapplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
public class TestApplicationConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("SWAGGER-ENDPOINT")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.test.testapplication.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET,
                        newArrayList(new ResponseMessageBuilder()
                                        .code(500)
                                        .message("500 message")
                                        .responseModel(new ModelRef("Error"))
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(403)
                                        .message("Forbidden")
                                        .responseModel(new ModelRef("Forbidden"))
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(401)
                                        .message("Unauthorized")
                                        .responseModel(new ModelRef("Unauthorized"))
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(503)
                                        .message("Service unavailable")
                                        .responseModel(new ModelRef("Service unavailable"))
                                        .build()));

    }

    @Bean
    public Docket api1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("SWAGGER-BASIC")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());

    }



    private ApiInfo apiInfo() {
        return new ApiInfo(
                "My test application with MVC",
                "This example is made by Spring mvc and I will test against Webflux with the same functionality",
                "version 1.0.0",
                "Terms of service",
                new Contact("Hector Jimenez", "www.myWeb.com", "myeaddress@company.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
