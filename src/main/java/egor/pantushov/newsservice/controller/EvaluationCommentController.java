package egor.pantushov.newsservice.controller;


import egor.pantushov.newsservice.service.EvaluationCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("news/articles/{articleId:\\d+}/{commentId:\\d+}")
public class EvaluationCommentController {

    private final EvaluationCommentService evaluationCommentService;

    @PreAuthorize("hasAnyAuthority('USER','EDITOR','ADMIN')")
    @PostMapping("/likeComment")
    public String addEvaluationArticleLike(@PathVariable Long articleId, @PathVariable Long commentId, Principal principal) {
        this.evaluationCommentService.addEvaluationCommentLike(commentId, principal);
        return "redirect:/news/articles/article/" + articleId;
    }

    @PreAuthorize("hasAnyAuthority('USER','EDITOR','ADMIN')")
    @PostMapping("/dislikeComment")
    public String addEvaluationArticleDisLike(@PathVariable Long articleId, @PathVariable Long commentId, Principal principal) {
        this.evaluationCommentService.addEvaluationCommentDislike(commentId, principal);
        return "redirect:/news/articles/article/" + articleId;
    }

}