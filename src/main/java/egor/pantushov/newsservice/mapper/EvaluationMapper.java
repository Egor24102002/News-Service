package egor.pantushov.newsservice.mapper;

import egor.pantushov.newsservice.dto.response.EvaluationResponse;
import egor.pantushov.newsservice.entity.EvaluationArticle;
import egor.pantushov.newsservice.entity.EvaluationComment;
import egor.pantushov.newsservice.entity.Type;

import java.util.List;

public class EvaluationMapper {
    public static EvaluationResponse getEvaluationResponsebyArticle(List<EvaluationArticle> evaluationArticles) {
        long likes=  evaluationArticles.stream()
                .filter(evaluation -> evaluation.getType() == Type.LIKE)
                .count();
        long dislikes=  evaluationArticles.stream()
                .filter(evaluation -> evaluation.getType() == Type.DISLIKE)
                .count();
                return new EvaluationResponse(likes,dislikes);
    }

    public static EvaluationResponse getEvaluationResponseByComment(List<EvaluationComment> evaluationComments) {
        long likes=  evaluationComments.stream()
                .filter(evaluation -> evaluation.getType() == Type.LIKE)
                .count();
        long dislikes=  evaluationComments.stream()
                .filter(evaluation -> evaluation.getType() == Type.DISLIKE)
                .count();
        return new EvaluationResponse(likes,dislikes);
    }

}
