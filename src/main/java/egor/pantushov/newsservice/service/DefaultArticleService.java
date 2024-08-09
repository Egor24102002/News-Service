package egor.pantushov.newsservice.service;

import egor.pantushov.newsservice.entity.Article;
import egor.pantushov.newsservice.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DefaultArticleService implements ArticleService {
    private final ArticleRepository articleRepository;

    @Override
    public List<Article> findAllArticles(){
        return this.articleRepository.findAll();
    }

    @Override
    public Article createArticle(String title, String details) {
        return this.articleRepository.saveArticle(new Article(null,title,details,null));
    }

    @Override
    public Optional<Article> findArticle(int id) {
        return this.articleRepository.findById( id);
    }
}
