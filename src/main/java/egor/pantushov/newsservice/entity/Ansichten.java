package egor.pantushov.newsservice.entity;

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
@Table(name = "ansichtens")
public class Ansichten {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ansichten_id")
    private Long ansichtenId;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    public void setUser(User user) {
        this.user = user;
        user.addAnsichtens(this);
    }


    public void setArticle(Article article) {
        this.article = article;
        article.addAnsichtens(this);
    }
}
