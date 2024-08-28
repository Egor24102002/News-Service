package egor.pantushov.newsservice.dto.request;


import egor.pantushov.newsservice.enums.Category;
import lombok.Value;

@Value
public class CommentRequest {
    Long commentId;
    String text;
    Long articleId;
}