package egor.pantushov.newsservice.service;

import egor.pantushov.newsservice.entity.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
     List<Article> findAllArticles();
     Article createArticle(String title,String details);
     Optional<Article> findArticle(int id);
}
