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
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long articleId;
    @Column( length=64,nullable=false)
    private String title;
    @Column(nullable=false)
    private String content;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;
    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
   private Category category;
    @CreationTimestamp
    @Column(name = "date_of_create",nullable = false)
    private Timestamp dateOfCreate;
    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany(mappedBy = "article")
    private List<Comment> comments=new ArrayList<>();
    @Builder.Default
    @OneToMany(mappedBy = "article")
    private List<EvaluationArticle> evaluationArticles=new ArrayList<>();
    @Builder.Default
    @OneToMany(mappedBy = "article")
    private List<Ansichten> ansichtens=new ArrayList<>();
    public void setAuthor(User author) {
        this.author = author;
        author.addArticle(this);
    }

    public void addComment(Comment comment) {
        if (comment != null) {
            this.comments.add(comment);
        }
    }
    public void addEvaluationsArticles(EvaluationArticle evaluationArticle) {
        if (evaluationArticle != null) {
            this.evaluationArticles.add(evaluationArticle);
        }
    }

    public void addAnsichtens(Ansichten ansichten) {
        if (ansichten != null) {
            this.ansichtens.add(ansichten);
        }
    }
}



