package egor.pantushov.newsservice.service;

import egor.pantushov.newsservice.dto.request.ArticleRequest;
import egor.pantushov.newsservice.dto.response.ArticleResponse;

import java.security.Principal;
import java.util.List;

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
    List<ArticleResponse> getVerificationsArticle();


    ArticleResponse approveArticle(Long articleId);

    ArticleResponse deleteArticle(Long articleId);
}
