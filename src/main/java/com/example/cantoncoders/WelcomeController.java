package com.example.cantoncoders;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

@Controller
public class WelcomeController {
    @RequestMapping("/")
    public String welcome()  {
       return "welcome";
    }
}