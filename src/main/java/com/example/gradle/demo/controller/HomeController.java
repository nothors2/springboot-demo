package com.example.gradle.demo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController implements ErrorController {

    @GetMapping("/")
    public String index() {
        System.out.println("/////");
        return "index.html";
    }

    @GetMapping("/error")
    public String redirect() {
        return "helloworld.html";
    }

    @GetMapping("/helloworld")
    public String helloworld() {
        return "helloworld";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}