package com.iconnate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.iconnate.utils.Constants;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author samarpit
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket appDocket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo).select()
				.apis(RequestHandlerSelectors.basePackage(Constants.BASE_PACKAGE)).paths(PathSelectors.any()).build();
	}

	ApiInfo apiInfo = new ApiInfoBuilder().title("HelpDesk Web Application")
			.description("admin can generate ticket ********************** ")
			.contact(new Contact("Samarpit", "https://iconnate.com", "developer@iconnate.com")).license("Licenses 1.0")
			.licenseUrl("https://iconnate.com").version("1.0.0").build();
}
