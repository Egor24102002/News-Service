package egor.pantushov.newsservice.entity;

import egor.pantushov.newsservice.enums.Category;
import egor.pantushov.newsservice.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    @Column(length=32, nullable=false, unique=true)
    private String email;
    @Column( length=32,nullable=false)
    private String password;
    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(length=32,nullable = false)
    private String firstname;
    @Column(length=32, nullable=false)
    private String lastname;
}