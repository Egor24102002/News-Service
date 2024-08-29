package egor.pantushov.newsservice.dto.request;

import lombok.Value;


@Value
public class UserRequest {
String username;
String password;
String firstname;
String lastname;
//Role role;
}
