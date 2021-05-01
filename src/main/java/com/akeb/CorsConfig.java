package com.akeb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
 import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CorsConfig implements WebMvcConfigurer{
	String[] origins = new String[]{"http://localhost:4200", "https://akebweb.herokuapp.com/" , "akebweb.herokuapp.com/"};
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedHeaders("*")
        .allowedOrigins(origins) 
        .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
        
    }
}
