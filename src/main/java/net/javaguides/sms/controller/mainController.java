package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {
	@GetMapping("/login")
    public String login() {
        return "login";
    }
	@GetMapping("/")
    public String index() {
        return "index";
    }

}
