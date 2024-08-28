package egor.pantushov.newsservice.service;

import egor.pantushov.newsservice.dto.request.UserRequest;
import egor.pantushov.newsservice.dto.response.UserResponse;
import egor.pantushov.newsservice.entity.User;
import egor.pantushov.newsservice.entity.Article;
import egor.pantushov.newsservice.enums.Role;
import egor.pantushov.newsservice.exeption.UserNotFoundException;
import egor.pantushov.newsservice.mapper.UserMapper;
import egor.pantushov.newsservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

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

}