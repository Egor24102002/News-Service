package egor.pantushov.newsservice.entity;


import egor.pantushov.newsservice.enums.Category;
import egor.pantushov.newsservice.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
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
    @OneToMany(mappedBy = "article")
    private List<Evaluation> evaluations=new ArrayList<>();
    public void setAuthor(User author) {
        this.author = author;
        author.addArticle(this);
    }

    public void addComment(Comment comment) {
        if (comment != null) {
            this.comments.add(comment);
        }
    }

    public void addEvaluation(Evaluation evaluation) {
        if (evaluation != null) {
            this.evaluations.add(evaluation);
        }
    }


}
