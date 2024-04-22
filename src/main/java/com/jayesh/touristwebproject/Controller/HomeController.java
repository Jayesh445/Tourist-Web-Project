package com.jayesh.touristwebproject.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.jayesh.touristwebproject.DTO.UserDTO;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.Controller;
//import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(HttpServletRequest request,Model m){
         System.out.println((request.getAttribute("user")));
        UserDTO user = (UserDTO) request.getAttribute("user");
        m.addAttribute("user1",user);
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
    public ModelAndView feedback(HttpServletRequest request,ModelAndView view){
        System.out.println((request.getAttribute("user1")));
        UserDTO user = (UserDTO) request.getAttribute("user1");
        view.addObject("user",user);
        // model.addAttribute("user", request.getSession().getAttribute("user"));
        // view.addObject("user", request.getAttribute("user"));
        view.setViewName("feedback.html");
        return view;
    }

    @GetMapping("/logout")
    public RedirectView logout(HttpServletRequest req, RedirectView redirectView) {
        req.getSession().removeAttribute("user");
        redirectView.setUrl("/");
        return redirectView;
    }
    
}
