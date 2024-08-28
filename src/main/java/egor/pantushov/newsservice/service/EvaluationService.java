package egor.pantushov.newsservice.service;

import egor.pantushov.newsservice.dto.request.EvaluationRequest;
import egor.pantushov.newsservice.dto.response.ArticleResponse;

import java.security.Principal;

public interface EvaluationService {
    ArticleResponse addLikeArticle(Long id, Principal principal, EvaluationRequest evaluationRequest);
}
