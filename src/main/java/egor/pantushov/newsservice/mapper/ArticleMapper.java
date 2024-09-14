package egor.pantushov.newsservice.mapper;

import egor.pantushov.newsservice.dto.request.ArticleRequest;
import egor.pantushov.newsservice.dto.response.*;
import egor.pantushov.newsservice.entity.Article;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class ArticleMapper {
    public static ArticleResponse getArticleResponse(Article article) {
        List<CommentResponse> commentResponses = Optional.ofNullable(article.getComments())
                .map(comments -> comments.stream()
                        .filter(comment -> Boolean.FALSE.equals(comment.getIsDeleted()))
                        .map(CommentMapper::getCommentResponse)
                        .collect(Collectors.toList()))
                .orElse(null);
        String dateOfCreate = article.getDateOfCreate().toString();
        AnsichtenResponse ansichtenResponse = Optional.ofNullable(article.getAnsichtens())
                .map(AnsichtenMapper::getAnsichtenResponseByArticle).orElse(null);
        EvaluationResponse evaluationArticleResponse = Optional.ofNullable(article.getEvaluationArticles())
                .map(EvaluationMapper::getEvaluationResponsebyArticle).orElse(null);
        return new ArticleResponse(
                article.getArticleId(),
                article.getTitle(),
                article.getContent(),
                dateOfCreate.substring(0, dateOfCreate.length() - 5),
                UserMapper.getUserResponse(article.getAuthor()),
                commentResponses,
                evaluationArticleResponse,
                ansichtenResponse
        );
    }


    public static Article getArticle(Article article, ArticleRequest articleRequest) {
        article.setTitle(articleRequest.getTitle());
        article.setContent(articleRequest.getContent());
        article.setCategory(articleRequest.getCategory());
        return article;
    }


}
