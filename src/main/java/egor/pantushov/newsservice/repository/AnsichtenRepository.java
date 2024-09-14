package egor.pantushov.newsservice.repository;

import egor.pantushov.newsservice.entity.Ansichten;
import egor.pantushov.newsservice.entity.Article;
import egor.pantushov.newsservice.entity.EvaluationArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AnsichtenRepository extends JpaRepository<Ansichten, Long> {
    @Query("select u from Ansichten u where u.article.articleId = ?1 and u.user.userId = ?2")
    Optional<Ansichten> findAnsichtenByUserIdArticleId(Long articleId, Long userId);
}
