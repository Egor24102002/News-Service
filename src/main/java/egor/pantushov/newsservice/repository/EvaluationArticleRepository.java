package egor.pantushov.newsservice.repository;

import egor.pantushov.newsservice.entity.EvaluationArticle;
import egor.pantushov.newsservice.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EvaluationArticleRepository extends JpaRepository<EvaluationArticle,Long> {
    @Query("select u from EvaluationArticle u where u.article.articleId = ?1 and u.user.userId = ?2")
    Optional<EvaluationArticle> findEvaluationArticleByUserIdArticleId(Long articleId, Long userId);

}
