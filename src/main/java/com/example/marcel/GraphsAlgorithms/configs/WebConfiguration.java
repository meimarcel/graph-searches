package com.example.marcel.GraphsAlgorithms.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("POST").allowedOrigins("http://localhost", "https://graphsearchanimation.herokuapp.com", "http://graphsearchanimation.herokuapp.com");
    }
}
