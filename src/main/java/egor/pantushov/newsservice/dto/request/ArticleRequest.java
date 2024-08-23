package egor.pantushov.newsservice.dto.request;

import egor.pantushov.newsservice.dto.response.UserResponse;
import egor.pantushov.newsservice.enums.Category;
import egor.pantushov.newsservice.enums.Role;
import egor.pantushov.newsservice.enums.Status;
import lombok.Value;

import java.sql.Timestamp;

@Value
public class ArticleRequest {
    String title;
    String content;
    Category category;
}
