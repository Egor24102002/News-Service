package egor.pantushov.newsservice.mapper;

import egor.pantushov.newsservice.dto.response.CommentResponse;
import egor.pantushov.newsservice.dto.response.EvaluationArticleResponse;
import egor.pantushov.newsservice.dto.response.UserResponse;
import egor.pantushov.newsservice.entity.Comment;
import egor.pantushov.newsservice.entity.EvaluationArticle;
import egor.pantushov.newsservice.entity.Type;

import java.util.List;
import java.util.Optional;

public class EvaluationArticleMapper {
    public static EvaluationArticleResponse getEvaluationArticleResponse(List<EvaluationArticle> evaluationArticles) {
        long likes=  evaluationArticles.stream()
                .filter(evaluation -> evaluation.getType() == Type.LIKE)
                .count();
        long dislikes=  evaluationArticles.stream()
                .filter(evaluation -> evaluation.getType() == Type.DISLIKE)
                .count();
                return new EvaluationArticleResponse(likes,dislikes);
    }
}
