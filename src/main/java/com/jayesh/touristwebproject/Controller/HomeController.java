package com.jayesh.touristwebproject.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.Controller;
//import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "index.html";
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup.html";
    }

    @GetMapping("/feedback")
    public String feedback(){
        return "feedback.html";
    }

    @GetMapping("/logout")
    public RedirectView logout(HttpServletRequest req, RedirectView redirectView) {
        req.getSession().removeAttribute("user");
        redirectView.setUrl("/");
        return redirectView;
    }
    
}
