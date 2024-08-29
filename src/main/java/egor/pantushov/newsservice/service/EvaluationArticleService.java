package egor.pantushov.newsservice.service;

import egor.pantushov.newsservice.dto.response.ArticleResponse;
import egor.pantushov.newsservice.dto.response.EvaluationArticleResponse;

import java.security.Principal;

public interface EvaluationArticleService {
    ArticleResponse addEvaluationArticleLike(Long id, Principal principal);
    ArticleResponse addEvaluationArticleDislike(Long id, Principal principal);

}
