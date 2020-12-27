package com.ashokit.swaager;

import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2) // Swagger Screen
				.select() // read rest controllers
				.apis(basePackage("com.ashokit.controller")) // (api)rest controller from common package name
				.paths(regex("/.*")) // having one common starting path (/.*)
				.build() //create screen
				.useDefaultResponseMessages(false) // hide error codes at swagger
				.apiInfo(apiInfo()) //optional meta data
				;
		
	}
	private ApiInfo apiInfo() {
		return new ApiInfo(
				"UserManagement AshokIT APP", 
				"This is a sample Usermanagement Syatem", 
				"3.2 GA", 
				"https://ashokit.in/", 
				new Contact("Karthik", "https://ashokit.in/", "ashokit4you@gmail.com"), 
				"ashokit Lmtd License", 
				"https://ashokit.in/license", 
				Collections.emptyList());
	}
}
