package com.davidhernandezn.develop.ApiRest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WeConfig {
	//PETICIONES DE ORIGEN PESADO
	@Bean
	public WebMvcConfigurer configurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				WebMvcConfigurer.super.addCorsMappings(registry);
				registry.addMapping("/api/**").allowedMethods("POST", "PUT","GET","DELETE","OPTIONS")//TODO LO QUE PASE
				.allowedOrigins("http://localhost:4200");//DESDE QUE SERV VIENE LAS PETICIONES AL API
			}
		};
	}}
