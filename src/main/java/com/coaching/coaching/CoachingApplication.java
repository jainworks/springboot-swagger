package com.coaching.coaching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import org.springframework.context.annotation.Bean;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;










@SpringBootApplication
@EnableSwagger2

public class CoachingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoachingApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/student/**"))
				.apis(RequestHandlerSelectors.basePackage("com.coaching.coaching.controller"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails(){
		return new ApiInfo(
				"Coaching API",
				"Sample API for Mongo DB integration demo",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("JV", "", ""),
				"API Licencse",
				"API License url",
				Collections.emptyList());
	}

}
