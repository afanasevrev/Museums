package com.example.Museums;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/")
    private String getMainPage() {
        return "main";
    }
}
