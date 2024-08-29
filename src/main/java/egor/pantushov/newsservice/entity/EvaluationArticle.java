package egor.pantushov.newsservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "evaluations_articles")
public class EvaluationArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluation_id")
    private Long evaluationId;
    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Type type;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    public void setUser(User user) {
        this.user = user;
        user.addEvaluationArticles(this);
    }

   /* public void setComment(Comment comment) {
        this.comment = comment;
        comment.addEvaluation(this);
    }*/

    public void setArticle(Article article) {
        this.article = article;
    article.addEvaluationArticles(this);
    }

}