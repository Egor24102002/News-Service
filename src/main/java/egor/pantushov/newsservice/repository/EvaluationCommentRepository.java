package egor.pantushov.newsservice.repository;

import egor.pantushov.newsservice.entity.EvaluationArticle;
import egor.pantushov.newsservice.entity.EvaluationComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EvaluationCommentRepository extends JpaRepository<EvaluationComment,Long> {
    @Query("select u from EvaluationComment u where u.comment.commentId = ?1 and u.user.userId = ?2")
    Optional<EvaluationComment> findEvaluationCommentByUserIdArticleId(Long commentId, Long userId);

}
