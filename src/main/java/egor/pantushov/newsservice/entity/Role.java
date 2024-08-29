package egor.pantushov.newsservice.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    USER,
    EDITOR;

    @Override
    public String getAuthority() {
        return name();
    }
}
