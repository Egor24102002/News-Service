package egor.pantushov.newsservice.entity;

import egor.pantushov.newsservice.enums.Category;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
    @Column(nullable=false)
    private String text;
    @CreationTimestamp
    @Column(name = "date_of_comment",nullable = false)
    private Timestamp dateOfComment;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
    @OneToMany(mappedBy = "comment")
    private List<Evaluation> evaluations=new ArrayList<>();
    public void setUser(User user) {
        this.user = user;
        user.addComment(this);
    }

    public void setArticle(Article article) {
        this.article = article;
        article.addComment(this);
    }

    public void addEvaluation(Evaluation evaluation) {
        if (evaluation != null) {
            this.evaluations.add(evaluation);
        }
    }



}