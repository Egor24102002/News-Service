package egor.pantushov.newsservice.service.impl;

import egor.pantushov.newsservice.dto.response.AnsichtenResponse;
import egor.pantushov.newsservice.dto.response.ArticleResponse;
import egor.pantushov.newsservice.entity.*;
import egor.pantushov.newsservice.exeption.ArticleNotFoundException;
import egor.pantushov.newsservice.exeption.UserNotFoundException;
import egor.pantushov.newsservice.mapper.AnsichtenMapper;
import egor.pantushov.newsservice.mapper.ArticleMapper;
import egor.pantushov.newsservice.repository.AnsichtenRepository;
import egor.pantushov.newsservice.repository.ArticleRepository;
import egor.pantushov.newsservice.repository.EvaluationArticleRepository;
import egor.pantushov.newsservice.repository.UserRepository;
import egor.pantushov.newsservice.service.AnsichtenService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnsichtenServiceImpl implements AnsichtenService {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    private final AnsichtenRepository ansichtenRepository;

    @Transactional
    @Override
    public ArticleResponse addAnsichten(Long articleId, Principal principal) {
        User user = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UserNotFoundException(principal.getName()));
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new ArticleNotFoundException(articleId));
        Optional<Ansichten> optionalAnsichten = ansichtenRepository.findAnsichtenByUserIdArticleId(articleId, user.getUserId());
        if (optionalAnsichten.isPresent()) {
            return null;
        }
        Ansichten ansichten = new Ansichten();
        ansichten.setArticle(article);
        ansichten.setUser(user);
        ansichtenRepository.save(ansichten);
        article.addAnsichtens(ansichten);
        user.addAnsichtens(ansichten);
        return ArticleMapper.getArticleResponse(article);
    }
}
