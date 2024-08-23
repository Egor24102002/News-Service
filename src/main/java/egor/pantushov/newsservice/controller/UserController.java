package egor.pantushov.newsservice.controller;

import egor.pantushov.newsservice.dto.request.UserRequest;

import egor.pantushov.newsservice.dto.response.UserResponse;
import egor.pantushov.newsservice.entity.User;
import egor.pantushov.newsservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("news/users")
public class UserController {
    private final UserService userService;
    @GetMapping("create")
    public String getNewUser(){
        return "/news/users/registration";
    }

    @PostMapping("create")
    public String createUser(UserRequest userRequest){
        UserResponse userResponse=this.userService.createUser(userRequest);
        return "redirect:/news/login";
    }
}
