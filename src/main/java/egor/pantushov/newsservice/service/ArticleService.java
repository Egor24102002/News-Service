package egor.pantushov.newsservice.service;

import egor.pantushov.newsservice.dto.request.ArticleRequest;
import egor.pantushov.newsservice.dto.response.ArticleResponse;
import egor.pantushov.newsservice.entity.Category;

import java.security.Principal;
import java.util.List;

public interface ArticleService {
    ArticleResponse createArticle(Principal principal, ArticleRequest articleRequest);

    ArticleResponse findArticle(Long id);

    List<ArticleResponse> findArticlesByCategory(Category category);


    List<ArticleResponse> getPopularArticles();

    List<ArticleResponse> getVerificationsArticle();


    ArticleResponse approveArticle(Long articleId);

    ArticleResponse deleteArticle(Long articleId);
}
