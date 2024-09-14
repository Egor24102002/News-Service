package egor.pantushov.newsservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
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
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;
    @Column(nullable = false)
    private String text;
    @CreationTimestamp
    @Column(name = "date_of_comment", nullable = false)
    private Timestamp dateOfComment;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
    @Builder.Default
    @OneToMany(mappedBy = "comment")
    private List<EvaluationComment> evaluationComments = new ArrayList<>();
    @Builder.Default
    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    public void setUser(User user) {
        this.user = user;
        user.addComment(this);
    }

    public void setArticle(Article article) {
        this.article = article;
        article.addComment(this);
    }

    public void addEvaluationsComments(EvaluationComment evaluationComment) {
        if (evaluationComment != null) {
            this.evaluationComments.add(evaluationComment);
        }
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Boolean getIsDeleted() {
        return this.isDeleted;
    }

}