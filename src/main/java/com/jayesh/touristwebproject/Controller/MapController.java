package com.jayesh.touristwebproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class MapController {

    @PostMapping(value = "/map")
    public String map( @RequestParam("place") String city,Model m , HttpServletRequest request ) {
        m.addAttribute("user",request.getSession().getAttribute("user"));
        m.addAttribute("city", city);
        return "map.html";
    }

}
