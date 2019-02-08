package com.apartment.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.apartment.util.AppConstants;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

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
		return new Docket(DocumentationType.SWAGGER_2).groupName("user-service").apiInfo(getApiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.apartment.user")).paths(PathSelectors.any()).build()
				.useDefaultResponseMessages(false).produces(AppConstants.DEFAULT_PRODUCES_AND_CONSUMES)
				.consumes(AppConstants.DEFAULT_PRODUCES_AND_CONSUMES);
	}

	/**
	 * This method is intended to create ApiInfo instance
	 * 
	 * @return ApiInfo
	 */
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title("apartment-user-service")
				.description("apartment-user-service (request, response, status, error message etc)")
				.contact(new Contact("AMS-IT-CoE", "https://github.com/mksrepo/apartment-service-repo.git",
						"mrinmay.santra@gmail.com"))
				.version("1.0.0").build();
	}

}
