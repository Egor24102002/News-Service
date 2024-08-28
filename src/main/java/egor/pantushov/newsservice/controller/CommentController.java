package egor.pantushov.newsservice.controller;

import egor.pantushov.newsservice.dto.request.ArticleRequest;
import egor.pantushov.newsservice.dto.request.CommentRequest;
import egor.pantushov.newsservice.dto.response.CommentResponse;
import egor.pantushov.newsservice.enums.Category;
import egor.pantushov.newsservice.mapper.CommentMapper;
import egor.pantushov.newsservice.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("news/{articleId:\\d+}")
public class CommentController {
    private final CommentService commentService;
    @GetMapping("{commentId:\\d+}")
    public String getNewComment(Model model, @PathVariable Long commentId,@ModelAttribute("commentRequest") CommentRequest commentRequest){
        model.addAttribute("commentRequest", CommentMapper.getCommentRequest (this.commentService.findComment(commentId)));
        return "news/comments/update_comment";
    }

    @PostMapping("{commentId:\\d+}")
    public String UpdateNewComment(@PathVariable Long articleId, @ModelAttribute CommentRequest commentRequest){
        this.commentService.update(commentRequest);

        return "redirect:/news/articles/" + articleId;
    }


}
