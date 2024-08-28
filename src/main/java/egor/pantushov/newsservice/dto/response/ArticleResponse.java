package egor.pantushov.newsservice.dto.response;

import egor.pantushov.newsservice.enums.Category;
import lombok.Value;

import java.sql.Timestamp;
import java.util.List;

@Value
public class ArticleResponse {
    Long articleId;
    String title;
    String content;
    String dateOfCreate;
    UserResponse userResponse;
    List<CommentResponse> commentResponses;
    long likes;
    long dislikes;
}
