package egor.pantushov.newsservice.controller;

import egor.pantushov.newsservice.dto.request.CommentRequest;
import egor.pantushov.newsservice.dto.response.CommentResponse;
import egor.pantushov.newsservice.mapper.CommentMapper;
import egor.pantushov.newsservice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("news/articles/{articleId:\\d+}")
public class CommentController {
    private final CommentService commentService;


    @PostMapping()
    public String createComment(@PathVariable Long articleId, @ModelAttribute CommentRequest commentRequest , Principal principal){
        CommentResponse commentResponse=this.commentService.createComment(principal,commentRequest,articleId);
        return "redirect:/news/articles/" + commentResponse.getArticleId();
    }

    @GetMapping("/{commentId:\\d+}")
    public String getNewComment(Model model, @PathVariable Long commentId,@ModelAttribute("commentRequest") CommentRequest commentRequest){
        model.addAttribute("commentRequest", CommentMapper.getCommentRequest (this.commentService.findComment(commentId)));
        return "news/comments/update_comment";
    }

    @PostMapping("/{commentId:\\d+}")
    public String UpdateNewComment(@PathVariable Long articleId, @ModelAttribute CommentRequest commentRequest){
        this.commentService.update(commentRequest);

        return "redirect:/news/articles/" + articleId;
    }


}
