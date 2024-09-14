package egor.pantushov.newsservice.controller;


import egor.pantushov.newsservice.service.EvaluationArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("news/articles/{articleId:\\d+}")
public class EvaluationArticleController {

    private final EvaluationArticleService evaluationArticleService;

    @PreAuthorize("hasAnyAuthority('USER','ADMIN','EDITOR')")
    @PostMapping("/like")
    public String addEvaluationArticleLike(@PathVariable Long articleId, Principal principal) {
        this.evaluationArticleService.addEvaluationArticleLike(articleId, principal);
        return "redirect:/news/articles/article/" + articleId;
    }

    @PreAuthorize("hasAnyAuthority('USER','ADMIN','EDITOR')")
    @PostMapping("/dislike")
    public String addEvaluationArticleDisLike(@PathVariable Long articleId, Principal principal) {
        this.evaluationArticleService.addEvaluationArticleDislike(articleId, principal);
        return "redirect:/news/articles/article/" + articleId;
    }

}