package egor.pantushov.newsservice.service;

import egor.pantushov.newsservice.dto.request.UserRequest;
import egor.pantushov.newsservice.dto.response.UserResponse;
import egor.pantushov.newsservice.entity.Role;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);

    List<UserResponse> findAllUsers();

    UserResponse giveRole(Long userId, Role role);
}

