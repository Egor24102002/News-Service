package egor.pantushov.newsservice.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    Admin,
    User,
    Editor;

    @Override
    public String getAuthority() {
        return name();
    }
}
