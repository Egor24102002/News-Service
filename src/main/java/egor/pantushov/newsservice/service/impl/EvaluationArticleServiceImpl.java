package egor.pantushov.newsservice.service.impl;

import egor.pantushov.newsservice.dto.response.ArticleResponse;
import egor.pantushov.newsservice.entity.Article;
import egor.pantushov.newsservice.entity.EvaluationArticle;
import egor.pantushov.newsservice.entity.User;
import egor.pantushov.newsservice.entity.Type;
import egor.pantushov.newsservice.exeption.ArticleNotFoundException;

import egor.pantushov.newsservice.exeption.EvaluationArticleNotFoundException;
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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EvaluationArticleServiceImpl implements EvaluationArticleService {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    private final EvaluationArticleRepository evaluationArticleRepository;
    @Override
    public ArticleResponse addEvaluationArticleLike(Long articleId, Principal principal) {
        User user=userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UserNotFoundException(principal.getName()));
       Optional <EvaluationArticle> evaluationArticle=isHasEvaluationArticle(articleId,user.getUserId());
       if (evaluationArticle.isPresent()){
           if (evaluationArticle.get().getType()==Type.LIKE)
           {
               evaluationArticleRepository.delete(evaluationArticle.get());
               return null;
           }
           evaluationArticleRepository.delete(evaluationArticle.get());
        }
    Article article = articleRepository.findById(articleId)
            .orElseThrow(() -> new ArticleNotFoundException(articleId));
    EvaluationArticle evaluation = new EvaluationArticle();
    evaluation.setArticle(article);
    evaluation.setType(Type.LIKE);
    evaluation.setUser(user);
    evaluationArticleRepository.save(evaluation);
    article.addEvaluationsArticles(evaluation);
    user.addEvaluationsArticles(evaluation);
    return ArticleMapper.getArticleResponse(article);

    }


    @Override
    public ArticleResponse addEvaluationArticleDislike(Long articleId, Principal principal) {
        Article article= articleRepository.findById(articleId)
                .orElseThrow(() -> new ArticleNotFoundException(articleId));
        User user=userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UserNotFoundException(principal.getName()));
        Optional <EvaluationArticle> evaluationArticle=isHasEvaluationArticle(articleId,user.getUserId());
        if (evaluationArticle.isPresent()){
            if (evaluationArticle.get().getType()==Type.DISLIKE)
            {
                evaluationArticleRepository.delete(evaluationArticle.get());
                return null;
            }
            evaluationArticleRepository.delete(evaluationArticle.get());
        }
        EvaluationArticle evaluation=new EvaluationArticle();
        evaluation.setArticle(article);
        evaluation.setType(Type.DISLIKE);
        evaluation.setUser(user);
        evaluationArticleRepository.save(evaluation);
        article.addEvaluationsArticles(evaluation);
        user.addEvaluationsArticles(evaluation);
        return ArticleMapper.getArticleResponse(article);
    }

   public Optional<EvaluationArticle> isHasEvaluationArticle(Long articleId,Long userId){
        Optional<EvaluationArticle> optionalEvaluationArticle= evaluationArticleRepository.findEvaluationArticleByUserIdArticleId(articleId,userId);
    return optionalEvaluationArticle;
    }




}
