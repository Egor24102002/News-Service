package egor.pantushov.newsservice.entity;

import egor.pantushov.newsservice.enums.Category;
import egor.pantushov.newsservice.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "users" )
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(length=64, nullable=false, unique=true)
    private String username;
    @Column( length=64,nullable=false)
    private String password;
    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(length=32,nullable = false)
    private String firstname;
    @Column(length=32, nullable=false)
    private String lastname;
    @Builder.Default
    @OneToMany(mappedBy = "author")
    private List<Article> articles=new ArrayList<>();

    public void addArticle(Article article) {
        if (article != null) {
            this.articles.add(article);
        }
    }

}