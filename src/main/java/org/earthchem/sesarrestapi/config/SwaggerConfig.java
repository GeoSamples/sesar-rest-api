package org.earthchem.sesarrestapi.config;


import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()                 
                .apis(RequestHandlerSelectors.basePackage("org.earthchem.sesarrestapi.controller"))
                .paths(regex("/v1.*"))
                .build()
                .apiInfo(metaData());
             
    }
	  
	private ApiInfo metaData() {
	      return new ApiInfoBuilder()
	              .title("SESAR REST API")
	              .description("SESAR REST API for IGSN Registration")
	              .version("0.0.7")
	              .license("Apache License Version 2.0")
	              .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
	              .contact(new Contact("SESAR", "https://www.geosamples.org", "info@geosamples.org"))
	              .build();
	}
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry
                .addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
