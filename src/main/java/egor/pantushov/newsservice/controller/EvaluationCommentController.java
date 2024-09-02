package egor.pantushov.newsservice.controller;

import egor.pantushov.newsservice.dto.request.CommentRequest;
import egor.pantushov.newsservice.entity.EvaluationComment;
import egor.pantushov.newsservice.service.EvaluationArticleService;
import egor.pantushov.newsservice.service.EvaluationCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("news/articles/{articleId:\\d+}")
public class EvaluationCommentController {

    private final EvaluationCommentService evaluationCommentService;

    @PostMapping("/likeComment")
    public String addEvaluationArticleLike(@PathVariable Long articleId , @ModelAttribute CommentRequest commentRequest, Principal principal){
        this.evaluationCommentService.addEvaluationCommentLike(commentRequest.getCommentId(),principal);
        return "redirect:/news/articles/" +articleId;
    }

    @PostMapping("/dislikeComment")
    public String addEvaluationArticleDisLike(@PathVariable Long articleId ,@ModelAttribute CommentRequest commentRequest,Principal principal){
        this.evaluationCommentService.addEvaluationCommentDislike(commentRequest.getCommentId(),principal);
        return "redirect:/news/articles/" +articleId;
    }

}