package egor.pantushov.newsservice.service.impl;

import egor.pantushov.newsservice.dto.request.UserRequest;
import egor.pantushov.newsservice.dto.response.user.UserResponse;
import egor.pantushov.newsservice.entity.User;
import egor.pantushov.newsservice.entity.Role;
import egor.pantushov.newsservice.exeption.UserNotFoundException;
import egor.pantushov.newsservice.mapper.UserMapper;
import egor.pantushov.newsservice.repository.UserRepository;
import egor.pantushov.newsservice.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService,UserDetailsService {
    private  final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        return userRepository.findByUsername(username)
                .map(user->new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        "{noop}" + user.getPassword(),
                        Collections.singleton(user.getRole())
                ))
                .orElseThrow(()->new UserNotFoundException(username));
    }

    public UserResponse createUser(UserRequest userRequest) {
        User user=new User();
        user.setRole(Role.USER);
        UserMapper.getUser(user,userRequest);
        userRepository.save(user);
        return  UserMapper.getUserResponse(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

}