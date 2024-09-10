package egor.pantushov.newsservice.dto.request;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class CommentRequest {
    @NotEmpty(message = "Text must be not null")
    String text;
}