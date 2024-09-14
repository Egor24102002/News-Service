package egor.pantushov.newsservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("news/login")
    public String loginPage() {
        return "news/login";
    }

}
