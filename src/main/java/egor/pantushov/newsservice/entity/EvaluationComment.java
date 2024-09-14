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
@Table(name = "evaluations_comments")
public class EvaluationComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluation_comment_id")
    private Long evaluationCommentId;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    public void setUser(User user) {
        this.user = user;
        user.addEvaluationsComments(this);
    }

    public void setComment(Comment comment) {
        this.comment = comment;
        comment.addEvaluationsComments(this);
    }

}