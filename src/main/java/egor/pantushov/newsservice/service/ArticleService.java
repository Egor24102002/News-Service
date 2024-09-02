package egor.pantushov.newsservice.service;

import egor.pantushov.newsservice.dto.request.ArticleRequest;
import egor.pantushov.newsservice.dto.response.ArticleResponse;
import egor.pantushov.newsservice.entity.Article;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

public interface ArticleService {
     ArticleResponse createArticle(Principal principal,ArticleRequest articleRequest);
    ArticleResponse findArticle(Long id);
    List<ArticleResponse> findSportArticles();
    List<ArticleResponse> findWarArticles();
    List<ArticleResponse> findPoliticArticles();
    List<ArticleResponse> findOtherArticles();
    List<ArticleResponse> findGlobalArticles();
    List<ArticleResponse> findCultureArticles();
    List<ArticleResponse> getPopularArticles();

    List<ArticleResponse> getVerificationArticle();
}
