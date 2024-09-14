package egor.pantushov.newsservice.repository;

import egor.pantushov.newsservice.entity.Article;
import egor.pantushov.newsservice.entity.Category;
import egor.pantushov.newsservice.entity.Status;
import egor.pantushov.newsservice.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByCategoryAndStatus(Category category, Status status);

    List<Article> findAllByStatus(Status status);
}
