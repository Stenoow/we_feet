package com.wefeet.wefeet.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Permettre CORS sur les routes commençant par /api
                .allowedOrigins("http://localhost:4200")  // Autoriser Angular en développement
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Méthodes HTTP autorisées
                .allowedHeaders("*")  // Autoriser tous les en-têtes
                .allowCredentials(true);  // Autoriser les cookies si nécessaire
    }
}
