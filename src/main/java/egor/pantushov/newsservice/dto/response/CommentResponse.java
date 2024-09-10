package egor.pantushov.newsservice.dto.response;

import lombok.Value;

@Value
public class CommentResponse {
    String text;
    String date;
    UserResponse userResponse;
    Long commentId;
    Long articleId;
    EvaluationResponse evaluationResponse;
}
