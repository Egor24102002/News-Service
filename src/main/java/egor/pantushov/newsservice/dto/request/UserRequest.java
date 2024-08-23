package egor.pantushov.newsservice.dto.request;

import egor.pantushov.newsservice.enums.Role;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Value;


@Value
public class UserRequest {
String username;
String password;
String firstname;
String lastname;
//Role role;
}
