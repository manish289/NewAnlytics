package com.isource.config.swagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;


@Configuration
@SecurityScheme(
		  name = "bearerAuth",
		  type = SecuritySchemeType.HTTP,
		  bearerFormat = "JWT",
		  scheme = "bearer"
		)
@OpenAPIDefinition(info = @Info(   
		title = "CAR-M",                                           // it will give information in swagger at the top.
		description = "Compititor Analytics Report - ISTPL Product", 
		version = "v1", 
		termsOfService = "https://www.tender247.com/TermsAndCondition",
		license = @License(
				name = "ISTPL", 
				url = "https://www.tender247.com/")))



public class OpenAPI30Configuration  {

	@Bean
	public OpenAPI customizeOpenAPI() {
	    final String securitySchemeName = "bearerAuth";
	    
	    return new OpenAPI()         // all are classes or methods given by OpenApi() 
	      .addSecurityItem(new SecurityRequirement()
	        .addList(securitySchemeName))
	      .components(new Components()
	        );
	    }

}
















