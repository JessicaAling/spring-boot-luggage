package com.luggage.service.luggageservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController implements ErrorController {

    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homePage() {
        return appName;
    }

    @GetMapping("/error")
    public String errorPage() {
        return appName + "  ERROR on application.";
    }

    @Override
    public String getErrorPath() {
        return "Error";
    }
}



