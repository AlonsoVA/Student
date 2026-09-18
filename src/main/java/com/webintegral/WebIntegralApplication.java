package com.webintegral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Indica que esta clase es la aplicación principal de Spring Boot
@SpringBootApplication
public class WebIntegralApplication {

    // Método principal para iniciar la aplicación
    public static void main(String[] args) {
        SpringApplication.run(WebIntegralApplication.class, args);
    }
}