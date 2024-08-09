package egor.pantushov.newsservice.entity;


import egor.pantushov.newsservice.enums.Category;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Integer articleId;
    @Column( length=64,nullable=false)
    private String title;
    @Column(nullable=false)
    private String content;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
   private Category category;
    @CreationTimestamp
    @Column(name = "date_of_create",nullable = false)
    private LocalDate dateOfCreate;
    @UpdateTimestamp
    @Column(name = "date_of_update")
    private LocalDate dateOfUpdate;
}
