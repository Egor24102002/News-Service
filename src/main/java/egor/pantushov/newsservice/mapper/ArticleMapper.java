package egor.pantushov.newsservice.mapper;

import egor.pantushov.newsservice.dto.request.ArticleRequest;
import egor.pantushov.newsservice.dto.request.UserRequest;
import egor.pantushov.newsservice.dto.response.ArticleResponse;
import egor.pantushov.newsservice.dto.response.UserResponse;
import egor.pantushov.newsservice.entity.Article;
import egor.pantushov.newsservice.entity.User;
import egor.pantushov.newsservice.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ArticleMapper {
    private final UserMapper userMapper;
    public static ArticleResponse getArticleResponse(Article article) {
        UserResponse userResponse= Optional.ofNullable(article.getAuthor())
                .map(UserMapper::getUserResponse).orElse(null);
    String dateOfCreate=article.getDateOfCreate().toString();
        return new ArticleResponse(
                article.getArticleId(),
                article.getTitle(),
                article.getContent(),
                dateOfCreate.substring(0,dateOfCreate.length()-5),
                userResponse
                );
    }


    public static Article getArticle(Article article,ArticleRequest articleRequest) {
article.setTitle(articleRequest.getTitle());
article.setContent(articleRequest.getContent());
article.setCategory(articleRequest.getCategory());
return article;
    }



}
