package egor.pantushov.newsservice.mapper;

import egor.pantushov.newsservice.dto.request.UserRequest;
import egor.pantushov.newsservice.dto.response.UserResponse;
import egor.pantushov.newsservice.entity.User;


public class UserMapper {
    public static User getUser(User user, UserRequest userRequest) {
        user.setFirstname(userRequest.getFirstname());
        user.setLastname(userRequest.getLastname());
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        return user;
    }


    public static UserResponse getUserResponse(User user) {

        return new UserResponse(user.getFirstname(), user.getLastname(), user.getRole(), user.getUserId());
    }


}
