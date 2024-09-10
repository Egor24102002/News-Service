package egor.pantushov.newsservice.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Value;


@Value
public class UserRequest {

    @NotEmpty(message = "Username must be not null")
    @Email(message = "Username must be a valid email address")
String username;
    @Size(min = 3)
    @NotEmpty(message = "Password must be not null")
    String password;
    @NotEmpty(message = "Firstname must be not null")
    String firstname;
    @NotEmpty(message = "Lastname must be not null")
    String lastname;
}
