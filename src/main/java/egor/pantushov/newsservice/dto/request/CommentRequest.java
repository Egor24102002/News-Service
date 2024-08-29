package egor.pantushov.newsservice.dto.request;


import lombok.Value;

@Value
public class CommentRequest {
    Long commentId;
    String text;
    Long articleId;
}