package egor.pantushov.newsservice.dto.response.user;

import egor.pantushov.newsservice.entity.Role;
import lombok.Value;


@Value
    public class UserResponse {
        String firstname;
        String lastname;
}
