package egor.pantushov.newsservice.entity;

import jakarta.persistence.*;
import lombok.*;

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
    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<Comment> comments=new ArrayList<>();
    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<EvaluationArticle> evaluationArticles=new ArrayList<>();
    public void addArticle(Article article) {
        if (article != null) {
            this.articles.add(article);
        }
    }
    public void addComment(Comment comment) {
        if (comment != null) {
            this.comments.add(comment);
        }
    }
    public void addEvaluationArticles(EvaluationArticle evaluationArticle) {
        if (evaluationArticle != null) {
            this.evaluationArticles.add(evaluationArticle);
        }
    }

}