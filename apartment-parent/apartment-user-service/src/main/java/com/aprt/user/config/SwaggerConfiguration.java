/*
 * ApplicationStarter.java
 * 
 * Description: application starter
 * 
 * Maintenance History
 * YYMMDD	Who					Reason
 * ==================================================================
 * 190131	Surya Yadav		Initial Version
 */
package com.aprt.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aprt.util.AppConstants;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * <h1>Application Starter</h1>
 * This class is responsible for Swagger configuration
 * <p>
 * <b>Note:</b> This class doesn't carries out any requirement
 *
 * @author Surya Yadav
 * @version 1.0
 * @since 2019-01-34
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	/**
	 * This method is intended to configure Swagger
	 * 
	 * @return Docket
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).
				groupName("user-service").apiInfo(getApiInfo()).
				select().
				apis(RequestHandlerSelectors.basePackage("com.aprt.user")).
				paths(PathSelectors.any()).
				build().
				useDefaultResponseMessages(false).
				produces(AppConstants.DEFAULT_PRODUCES_AND_CONSUMES).
				consumes(AppConstants.DEFAULT_PRODUCES_AND_CONSUMES);
	}

	/**
	 * This method is intended to create ApiInfo instance
	 * 
	 * @return ApiInfo
	 */
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().
				title("apartment-user-service").
				description("apartment-user-service (request, response, status, error message etc)").
				contact(new Contact("AMS-IT-CoE","https://github.com/mksrepo/apartment-service-repo.git","mrinmay.santra@gmail.com" )).
				version("1.0.0").
				build();
	}

}
