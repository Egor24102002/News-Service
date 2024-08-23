package egor.pantushov.newsservice.dto.response;

import egor.pantushov.newsservice.enums.Category;
import lombok.Value;

import java.sql.Timestamp;

@Value
public class ArticleResponse {
    Long articleId;
    String title;
    String content;
    String dateOfCreate;
    UserResponse userResponse;
}
