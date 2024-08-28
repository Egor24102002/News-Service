package egor.pantushov.newsservice.service;

import egor.pantushov.newsservice.dto.request.ArticleRequest;
import egor.pantushov.newsservice.dto.response.ArticleResponse;
import egor.pantushov.newsservice.entity.Article;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

public interface ArticleService {
     List<ArticleResponse> findAllArticles();
     ArticleResponse createArticle(Principal principal,ArticleRequest articleRequest);
    ArticleResponse findArticle(Long id);

}
