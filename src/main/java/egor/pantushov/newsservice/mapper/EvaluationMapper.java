package egor.pantushov.newsservice.mapper;

import egor.pantushov.newsservice.dto.request.CommentRequest;
import egor.pantushov.newsservice.dto.request.EvaluationRequest;
import egor.pantushov.newsservice.entity.Comment;
import egor.pantushov.newsservice.entity.Evaluation;
import org.springframework.stereotype.Component;

@Component
public class EvaluationMapper {
    public static Evaluation getEvaluation(EvaluationRequest evaluationRequest, Evaluation evaluation) {
       evaluation.setType(evaluationRequest.getType());
       return evaluation;
    }

}
