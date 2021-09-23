package ua.testing.registration_form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController {

    @RequestMapping("/")
    public String mainPage(){
        return "index.html";
    }

    @RequestMapping("/api")
    public String apiPage(){
        return "index.html";
    }

    @RequestMapping("/form")
    public String regForm(){
        return "reg_form";
    }
}
