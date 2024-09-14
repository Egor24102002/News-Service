package egor.pantushov.newsservice.dto.response;

import egor.pantushov.newsservice.entity.Category;
import egor.pantushov.newsservice.entity.Role;
import lombok.Value;


@Value
public class UserResponse {
    String firstname;
    String lastname;
    Role role;
    Long userId;
}
