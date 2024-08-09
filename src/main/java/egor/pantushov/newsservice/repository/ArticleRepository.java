package egor.pantushov.newsservice.repository;

import egor.pantushov.newsservice.entity.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository {
    List<Article> findAll();
    Article saveArticle(Article article);
    Optional<Article> findById(Integer id);
}
