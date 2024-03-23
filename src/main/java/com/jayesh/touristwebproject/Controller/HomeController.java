package com.jayesh.touristwebproject.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "index.jsp";
    }

    @GetMapping("/login")
    public String login() {
        return "login.jsp";
    }
}
