package org.earthchem.sesarrestapi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan
public class WebConfig implements WebMvcConfigurer {

	/*
     * Configure ContentNegotiationManager
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {        
        configurer.favorPathExtension(true).
        favorParameter(false).
        parameterName("mediaType").
        ignoreAcceptHeader(false).
        defaultContentType(MediaType.APPLICATION_JSON_UTF8).
        mediaType("xml", MediaType.APPLICATION_XML). 
        mediaType("json", MediaType.APPLICATION_JSON);
       // mediaType("application/xml", MediaType.APPLICATION_XML). 
       // mediaType("application/json", MediaType.APPLICATION_JSON_UTF8);  
    }
}
