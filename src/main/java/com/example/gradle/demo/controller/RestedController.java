package com.example.gradle.demo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.*;

@Controller
public class RestedController {
    /*
    1. 화면에 helloworld가 출력됩니다.
    */
    @GetMapping(value = "/helloworld/string")
    @ResponseBody
    public String helloworldString() {
        return "helloworld";
    }
    /*
    2. 화면에 {message:"helloworld"} 라고 출력됩니다.
    */
    @GetMapping(value = "/helloworld/json")
    @ResponseBody
    public Hello helloworldJson() {
        Hello hello = new Hello();
        hello.message = "helloworld";
        return hello;
    }
    /*
    3. 화면에 helloworld.ftl의 내용이 출력됩니다.
    */
    @GetMapping("/helloworld/page")
    public String helloworld() {
        return "helloworld.html";
    }
    
    @Setter
    @Getter
    public static class Hello {
        public String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}