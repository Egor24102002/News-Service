package egor.pantushov.newsservice.service.impl;

import egor.pantushov.newsservice.dto.request.ArticleRequest;
import egor.pantushov.newsservice.dto.response.ArticleResponse;
import egor.pantushov.newsservice.entity.Article;
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
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    @Override
    public List<ArticleResponse> findAllArticles() {
        return articleRepository.findAll().stream()
                .filter(status->status.getStatus()== Status.PUBLICATION)
                .map(ArticleMapper::getArticleResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ArticleResponse createArticle(Principal principal, ArticleRequest articleRequest) {
    Article article=new Article();
   User user=userRepository.findByUsername(principal.getName())
           .orElseThrow(() -> new UserNotFoundException(principal.getName()));
        article.setAuthor(user);
        article.setStatus(Status.PUBLICATION);
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




}
