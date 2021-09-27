package ua.testing.demo_jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/api")
    public String mainPage(){
        return "index.html";
    }

    @RequestMapping("/all_user")
    public String userPage(){
        return "users/index.html";
    }
}
