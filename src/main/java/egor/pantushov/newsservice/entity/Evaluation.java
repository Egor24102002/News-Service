package egor.pantushov.newsservice.entity;

import egor.pantushov.newsservice.enums.Category;
import egor.pantushov.newsservice.enums.Type;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "evaluations")
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluation_id")
    private Long evaluationId;
    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Type type;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    public void setUser(User user) {
        this.user = user;
        user.setEvaluation(this);
    }

    public void setComment(Comment comment) {
        this.comment = comment;
        comment.addEvaluation(this);
    }

    public void setArticle(Article article) {
        this.article = article;
    article.addEvaluation(this);
    }

}