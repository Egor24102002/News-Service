package egor.pantushov.newsservice.controller;

import egor.pantushov.newsservice.dto.request.CommentRequest;
import egor.pantushov.newsservice.dto.response.CommentResponse;
import egor.pantushov.newsservice.mapper.CommentMapper;
import egor.pantushov.newsservice.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("news/articles/{articleId:\\d+}")
public class CommentController {
    private final CommentService commentService;

    @PreAuthorize("hasAnyAuthority('USER','EDITOR','ADMIN')")
    @PostMapping()
    public String createComment(@PathVariable Long articleId, @Valid @ModelAttribute CommentRequest commentRequest , Principal principal){
        this.commentService.createComment(principal,commentRequest,articleId);
        return "redirect:/news/articles/" + articleId;
    }

    @PreAuthorize("hasAnyAuthority('USER','EDITOR','ADMIN')")
    @PostMapping("/delete/{commentId:\\d+}")
    public String deleteComment(@PathVariable Long commentId,Principal principal,@PathVariable Long articleId){
        this.commentService.deleteComment(principal,commentId);
        return "redirect:/news/articles/" + articleId;
    }

    @GetMapping("/{commentId:\\d+}")
    public String getNewCommentForUpdate(Model model,Principal principal, @PathVariable Long commentId, @ModelAttribute("commentRequest") CommentRequest commentRequest){
            CommentResponse commentResponse = this.commentService.getNewCommentForUpdate(commentId, principal);
        model.addAttribute("commentResponse",commentResponse);
        model.addAttribute("commentRequest", CommentMapper.getCommentRequest (commentResponse));
        return "news/comments/update_comment";
    }

    @PreAuthorize("hasAnyAuthority('USER','EDITOR','ADMIN')")
    @PostMapping("/{commentId:\\d+}")
    public String UpdateNewComment(@PathVariable Long articleId, @Valid @ModelAttribute CommentRequest commentRequest,@PathVariable Long commentId){
        this.commentService.update(commentRequest,commentId);

        return "redirect:/news/articles/" + articleId;
    }


}
