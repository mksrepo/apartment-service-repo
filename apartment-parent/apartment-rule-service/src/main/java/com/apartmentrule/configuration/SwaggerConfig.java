package com.apartmentrule.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.apartmentrule.constant.ApartmentRuleConstants;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This is configuration class for Swagger implementation
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
		 /**
		  * Method is responsible for Swagger2 Documentation
		 * @return Docket docket
		 */
		@Bean
		  public Docket api() {
		    return new Docket(DocumentationType.SWAGGER_2)
		        .produces(ApartmentRuleConstants.DEFAULT_PRODUCES_AND_CONSUMES)
		        .consumes(ApartmentRuleConstants.DEFAULT_PRODUCES_AND_CONSUMES);
		  }

}
