package egor.pantushov.newsservice.controller;



import egor.pantushov.newsservice.service.EvaluationArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("news/articles/{articleId:\\d+}")
public class EvaluationArticleController {

    private final EvaluationArticleService evaluationService;

    @PostMapping("/like")
    public String addEvaluationArticleLike(@PathVariable Long articleId , Principal principal){
        this.evaluationService.addEvaluationArticleLike(articleId,principal);
        return "redirect:/news/articles";
    }

    @PostMapping("/dislike")
    public String addEvaluationArticleDisLike(@PathVariable Long articleId ,Principal principal){
        this.evaluationService.addEvaluationArticleDislike(articleId,principal);
        return "redirect:/news/articles";
    }

}