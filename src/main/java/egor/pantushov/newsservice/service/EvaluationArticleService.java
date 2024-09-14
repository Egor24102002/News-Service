package egor.pantushov.newsservice.service;

import egor.pantushov.newsservice.dto.response.ArticleResponse;
import egor.pantushov.newsservice.entity.EvaluationArticle;
import egor.pantushov.newsservice.entity.Type;

import java.security.Principal;
import java.util.Optional;

public interface EvaluationArticleService {
    ArticleResponse addEvaluationArticleLike(Long articleId, Principal principal);

    ArticleResponse addEvaluationArticleDislike(Long ArticleId, Principal principal);

}
