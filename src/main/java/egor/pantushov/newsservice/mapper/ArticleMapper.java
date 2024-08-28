package egor.pantushov.newsservice.mapper;

import egor.pantushov.newsservice.dto.request.ArticleRequest;
import egor.pantushov.newsservice.dto.request.UserRequest;
import egor.pantushov.newsservice.dto.response.ArticleResponse;
import egor.pantushov.newsservice.dto.response.CommentResponse;
import egor.pantushov.newsservice.dto.response.UserResponse;
import egor.pantushov.newsservice.entity.Article;
import egor.pantushov.newsservice.entity.Comment;
import egor.pantushov.newsservice.entity.User;
import egor.pantushov.newsservice.enums.Role;
import egor.pantushov.newsservice.enums.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ArticleMapper {
    private final UserMapper userMapper;
    public static ArticleResponse getArticleResponse(Article article) {
        UserResponse userResponse= Optional.ofNullable(article.getAuthor())
                .map(UserMapper::getUserResponse).orElse(null);
        List<CommentResponse> commentResponses = Optional.ofNullable(article.getComments())
                .map(comments -> comments.stream()
                        .map(CommentMapper::getCommentResponse)
                        .collect(Collectors.toList()))
                .orElse(null);
    String dateOfCreate=article.getDateOfCreate().toString();
       long likes=  article.getEvaluations().stream()
               .filter(evaluation -> evaluation.getType() == Type.LIKE)
               .count();
        long dislikes=  article.getEvaluations().stream()
                .filter(evaluation -> evaluation.getType() == Type.DISLIKE)
                .count();
        return new ArticleResponse(
                article.getArticleId(),
                article.getTitle(),
                article.getContent(),
                dateOfCreate.substring(0,dateOfCreate.length()-5),
                userResponse,
                commentResponses,
                likes,
                dislikes
                );
    }


    public static Article getArticle(Article article,ArticleRequest articleRequest) {
article.setTitle(articleRequest.getTitle());
article.setContent(articleRequest.getContent());
article.setCategory(articleRequest.getCategory());
return article;
    }



}
