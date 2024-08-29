package egor.pantushov.newsservice.dto.request;

import egor.pantushov.newsservice.entity.Category;
import lombok.Value;

@Value
public class ArticleRequest {
    String title;
    String content;
    Category category;
}
