package egor.pantushov.newsservice.service;

import egor.pantushov.newsservice.dto.request.UserRequest;
import egor.pantushov.newsservice.dto.response.user.UserResponse;
import egor.pantushov.newsservice.entity.User;

import java.util.List;

public interface UserService  {
    UserResponse createUser(UserRequest userRequest);

    List<User> findAllUsers();
}

