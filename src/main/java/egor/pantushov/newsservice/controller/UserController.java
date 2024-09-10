package egor.pantushov.newsservice.controller;

import egor.pantushov.newsservice.dto.request.CommentRequest;
import egor.pantushov.newsservice.dto.request.UserRequest;

import egor.pantushov.newsservice.entity.Role;
import egor.pantushov.newsservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("news/users")
public class UserController {
    private final UserService userService;
    @PreAuthorize("permitAll()")
    @GetMapping("create")
    public String getNewUser(){
        return "/news/users/registration";
    }
    @PreAuthorize("permitAll()")
    @PostMapping("create")
    public String createUser(@Valid UserRequest userRequest){
        this.userService.createUser(userRequest);
        return "redirect:/news/login";
    }
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("")
    public String getAllUsers(Model model){
        model.addAttribute("roles", Role.values());
        model.addAttribute("usersResponse",this.userService.findAllUsers());
        return "/news/users/all_users";
    }
    @PreAuthorize("hasAnyAuthority('ADMIN')")
   @PostMapping("{userId:\\d+}/giveRole")
    public String giveRole(@PathVariable Long userId, Role role){
       this.userService.giveRole(userId,role);
         return "redirect:/news/articles";
    }



}
