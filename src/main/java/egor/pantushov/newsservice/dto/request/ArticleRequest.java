package egor.pantushov.newsservice.dto.request;

import egor.pantushov.newsservice.entity.Category;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class ArticleRequest {
    @Size(min = 6, max = 64)
    @NotEmpty(message = "Title must be not null")
    String title;
    @Size(min = 32)
    @NotEmpty(message = "Content must be not null")
    String content;
    Category category;
}
