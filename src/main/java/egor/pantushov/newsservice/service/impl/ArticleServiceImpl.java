package egor.pantushov.newsservice.service.impl;

import egor.pantushov.newsservice.dto.request.ArticleRequest;
import egor.pantushov.newsservice.dto.response.ArticleResponse;
import egor.pantushov.newsservice.entity.Article;
import egor.pantushov.newsservice.entity.Category;
import egor.pantushov.newsservice.entity.User;
import egor.pantushov.newsservice.entity.Status;
import egor.pantushov.newsservice.exeption.ArticleNotFoundException;
import egor.pantushov.newsservice.exeption.UserNotFoundException;
import egor.pantushov.newsservice.mapper.ArticleMapper;
import egor.pantushov.newsservice.repository.ArticleRepository;
import egor.pantushov.newsservice.repository.UserRepository;
import egor.pantushov.newsservice.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;


    @Override
    public ArticleResponse createArticle(Principal principal, ArticleRequest articleRequest) {
    Article article=new Article();
   User user=userRepository.findByUsername(principal.getName())
           .orElseThrow(() -> new UserNotFoundException(principal.getName()));
        article.setAuthor(user);
        article.setStatus(Status.VERIFICATION);
        ArticleMapper.getArticle(article, articleRequest);
        user.addArticle(article);
        articleRepository.save(article);
    return ArticleMapper.getArticleResponse(article);
    }

    @Override
    public ArticleResponse findArticle(Long id) {
        return articleRepository.findById(id).map(ArticleMapper::getArticleResponse)
                .orElseThrow(() -> new ArticleNotFoundException(id));
    }

    @Override
    public List<ArticleResponse> findSportArticles() {
        return articleRepository.findAllByCategoryAndStatus(Category.Sport,Status.PUBLICATION)
                .stream().map(ArticleMapper::getArticleResponse)
                .collect(Collectors.toList());

    }

    @Override
    public List<ArticleResponse> findWarArticles() {
        return articleRepository.findAllByCategoryAndStatus(Category.War,Status.PUBLICATION)
                .stream().map(ArticleMapper::getArticleResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleResponse> findPoliticArticles() {
        return articleRepository.findAllByCategoryAndStatus(Category.Politic,Status.PUBLICATION)
                .stream().map(ArticleMapper::getArticleResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleResponse> findOtherArticles() {
        return articleRepository.findAllByCategoryAndStatus(Category.Other,Status.PUBLICATION)
                .stream().map(ArticleMapper::getArticleResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleResponse> findGlobalArticles() {
        return articleRepository.findAllByCategoryAndStatus(Category.Global,Status.PUBLICATION)
                .stream().map(ArticleMapper::getArticleResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleResponse> findCultureArticles() {
        return articleRepository.findAllByCategoryAndStatus(Category.Culture,Status.PUBLICATION)
                .stream().map(ArticleMapper::getArticleResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleResponse> getPopularArticles() {
        return articleRepository.findAllByStatus(Status.PUBLICATION)
                .stream().map(ArticleMapper::getArticleResponse)
                .sorted((a1, a2) -> Long.compare(a2.getAnsichtenResponse().getAnsichtens(), a1.getAnsichtenResponse().getAnsichtens()))
                .collect(Collectors.toList());

    }

    @Override
    public List<ArticleResponse> getVerificationArticle() {
        return articleRepository.findAllByStatus(Status.VERIFICATION)
                .stream().map(ArticleMapper::getArticleResponse)
                .collect(Collectors.toList());
    }


}
