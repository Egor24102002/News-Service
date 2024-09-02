package egor.pantushov.newsservice.dto.response;

import egor.pantushov.newsservice.dto.response.user.UserResponse;
import lombok.Value;

@Value
public class CommentResponse {
    String text;
    String date;
    UserResponse userResponse;
    Long commentId;
    EvaluationResponse evaluationResponse;
}
