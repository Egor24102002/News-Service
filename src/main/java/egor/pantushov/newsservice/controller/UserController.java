package egor.pantushov.newsservice.controller;

import egor.pantushov.newsservice.dto.request.CommentRequest;
import egor.pantushov.newsservice.dto.request.UserRequest;

import egor.pantushov.newsservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        this.userService.createUser(userRequest);
        return "redirect:/news/login";
    }

    @GetMapping("")
    public String getAllUsers(Model model){
        model.addAttribute("users",this.userService.findAllUsers());
        return "/news/users/all_users";
    }


    @PostMapping("update")
    public String giveRole(UserRequest userRequest,@ModelAttribute CommentRequest commentRequest){
        this.userService.createUser(userRequest);
        return "redirect:/news/login";
    }

}
