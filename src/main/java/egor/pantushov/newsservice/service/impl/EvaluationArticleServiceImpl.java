package egor.pantushov.newsservice.service.impl;

import egor.pantushov.newsservice.dto.response.ArticleResponse;
import egor.pantushov.newsservice.dto.response.EvaluationArticleResponse;
import egor.pantushov.newsservice.entity.Article;
import egor.pantushov.newsservice.entity.EvaluationArticle;
import egor.pantushov.newsservice.entity.User;
import egor.pantushov.newsservice.entity.Type;
import egor.pantushov.newsservice.exeption.ArticleNotFoundException;
import egor.pantushov.newsservice.exeption.EvaluationArticleException;
import egor.pantushov.newsservice.exeption.UserNotFoundException;
import egor.pantushov.newsservice.mapper.ArticleMapper;
import egor.pantushov.newsservice.repository.ArticleRepository;
import egor.pantushov.newsservice.repository.EvaluationArticleRepository;
import egor.pantushov.newsservice.repository.UserRepository;
import egor.pantushov.newsservice.service.EvaluationArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EvaluationArticleServiceImpl implements EvaluationArticleService {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    private final EvaluationArticleRepository evaluationRepository;
    @Override
    public ArticleResponse addEvaluationArticleLike(Long id, Principal principal) {
        Article article= articleRepository.findById(id)
                .orElseThrow(() -> new ArticleNotFoundException(id));
        User user=userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UserNotFoundException(principal.getName()));
        EvaluationArticle evaluation=new EvaluationArticle();
        evaluation.setArticle(article);
        evaluation.setType(Type.LIKE);
        evaluation.setUser(user);
       evaluationRepository.save(evaluation);
       article.addEvaluationArticles(evaluation);
       user.addEvaluationArticles(evaluation);
       return ArticleMapper.getArticleResponse(article);

    }



    public ArticleResponse addEvaluationArticleDislike(Long id, Principal principal) {
        Article article= articleRepository.findById(id)
                .orElseThrow(() -> new ArticleNotFoundException(id));
        User user=userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UserNotFoundException(principal.getName()));
        EvaluationArticle evaluation=new EvaluationArticle();
        evaluation.setArticle(article);
        evaluation.setType(Type.DISLIKE);
        evaluation.setUser(user);
        evaluationRepository.save(evaluation);
        article.addEvaluationArticles(evaluation);
        user.addEvaluationArticles(evaluation);
        return ArticleMapper.getArticleResponse(article);
    }



}
