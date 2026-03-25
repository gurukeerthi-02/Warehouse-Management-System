package com.example.warehouseinventorymanagementbackend.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupLinkPrinter {

    @EventListener(ApplicationReadyEvent.class)
    public void printLinks() {
        String baseUrl = "http://localhost:8080";

        System.out.println("\n--- Swagger Link ---");
        System.out.println("Swagger UI:  " + baseUrl + "/swagger-ui/index.html");
        System.out.println("OpenAPI Doc: " + baseUrl + "/v3/api-docs");
        System.out.println("------------------------------------\n");
    }
}
