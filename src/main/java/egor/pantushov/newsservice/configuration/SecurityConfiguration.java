package egor.pantushov.newsservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(CsrfConfigurer::disable)
            .authorizeHttpRequests(auth->
                    auth
                            .requestMatchers("/news/login","/news/users/create") .permitAll()
                            .anyRequest()
                    .authenticated())
                    .formLogin(login->login
                            .loginPage("/news/login")
                            .defaultSuccessUrl("/news/articles")
                            .permitAll()
                    );
    return http.build();
}
}
