package com.resumeapp.sbresumebuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SbresumebuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbresumebuilderApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
				.allowedMethods("GET", "POST", "PUT", "DELETE")
				 .allowedHeaders("*")
				.allowedOrigins("http://localhost:3000");
				
			}	
		};
	}

}
