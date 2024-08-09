package egor.pantushov.newsservice.repository;

import egor.pantushov.newsservice.entity.Article;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class InMemoryArticleRepository implements ArticleRepository {
private final List<Article> articles=new LinkedList<>();


    @Override
    public List<Article> findAll() {
        return Collections.unmodifiableList(this.articles);
    }

    @Override
    public Article saveArticle(Article article) {
        article.setId(this.articles.stream()
                .max(Comparator.comparingInt(Article::getId))
                        .map(Article::getId)
                        .orElse(0)+1
                );
        article.setPublicationData(LocalDate.now());
        this.articles.add(article);
        return article;
    }

    @Override
    public Optional<Article> findById(Integer id) {
        return this.articles.stream().filter(
                article -> article.getId().equals(id)
        ).findFirst();
    }
}
