package egor.pantushov.newsservice.service.impl;

import egor.pantushov.newsservice.dto.request.EvaluationRequest;
import egor.pantushov.newsservice.dto.response.ArticleResponse;
import egor.pantushov.newsservice.entity.Article;
import egor.pantushov.newsservice.entity.Evaluation;
import egor.pantushov.newsservice.entity.User;
import egor.pantushov.newsservice.exeption.ArticleNotFoundException;
import egor.pantushov.newsservice.exeption.UserNotFoundException;
import egor.pantushov.newsservice.mapper.ArticleMapper;
import egor.pantushov.newsservice.mapper.EvaluationMapper;
import egor.pantushov.newsservice.repository.ArticleRepository;
import egor.pantushov.newsservice.repository.EvaluationRepository;
import egor.pantushov.newsservice.repository.UserRepository;
import egor.pantushov.newsservice.service.EvaluationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;

@RequiredArgsConstructor
@Service
public class EvaluationServiceImpl implements EvaluationService {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    private final EvaluationRepository evaluationRepository;
    @Override
    public ArticleResponse addLikeArticle(Long id, Principal principal, EvaluationRequest evaluationRequest) {
        Article article= articleRepository.findById(id)
                .orElseThrow(() -> new ArticleNotFoundException(id));
        User user=userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UserNotFoundException(principal.getName()));
        Evaluation evaluation=new Evaluation();
        evaluation.setArticle(article);
        evaluation.setUser(user);
       EvaluationMapper.getEvaluation(evaluationRequest,evaluation);
       evaluationRepository.save(evaluation);
       article.addEvaluation(evaluation);
       user.setEvaluation(evaluation);
       return ArticleMapper.getArticleResponse(article);
    }
}
