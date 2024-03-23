package com.jayesh.touristwebproject.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class MapController {

    @GetMapping("/map")
    public String map() {
        return "map.jsp";
    }

}
