package egor.pantushov.newsservice.controller;

import egor.pantushov.newsservice.dto.request.CommentRequest;
import egor.pantushov.newsservice.dto.response.CommentResponse;
import egor.pantushov.newsservice.entity.Category;
import egor.pantushov.newsservice.exeption.CommentSubmittedException;
import egor.pantushov.newsservice.mapper.CommentMapper;
import egor.pantushov.newsservice.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("news/articles/{articleId:\\d+}")
public class CommentController {
    private final CommentService commentService;

    @PreAuthorize("hasAnyAuthority('USER','EDITOR','ADMIN')")
    @PostMapping()
    public String createComment(RedirectAttributes redirectAttributes, @PathVariable Long articleId, @Valid @ModelAttribute CommentRequest commentRequest, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Комментарий не может быть пустым.");
            return "redirect:/news/articles/article/" + articleId;
        }
        this.commentService.createComment(principal, commentRequest, articleId);
        return "redirect:/news/articles/article/" + articleId;
    }

    @PreAuthorize("hasAnyAuthority('USER','EDITOR','ADMIN')")
    @PostMapping("/delete/{commentId:\\d+}")
    public String deleteComment(@PathVariable Long commentId, RedirectAttributes redirectAttributes, Principal principal, @PathVariable Long articleId) {
        try {
            this.commentService.deleteComment(principal, commentId);
        } catch (CommentSubmittedException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Вы не имеете прав.");
        }
        return "redirect:/news/articles/article/" + articleId;
    }

    @GetMapping("/{commentId:\\d+}")
    public String getNewCommentForUpdate(Model model, @PathVariable Long articleId, RedirectAttributes redirectAttributes, Principal principal, @PathVariable Long commentId, @ModelAttribute("commentRequest") CommentRequest commentRequest) {
        try {
            CommentResponse commentResponse = this.commentService.getNewCommentForUpdate(commentId, principal);
            model.addAttribute("commentResponse", commentResponse);
            model.addAttribute("commentRequest", CommentMapper.getCommentRequest(commentResponse));
            return "news/comments/update_comment";
        } catch (CommentSubmittedException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Вы не имеете прав.");
            return "redirect:/news/articles/article/" + articleId;
        }


    }

    @PreAuthorize("hasAnyAuthority('USER','EDITOR','ADMIN')")
    @PostMapping("/{commentId:\\d+}")
    public String UpdateNewComment(@PathVariable Long articleId, @Valid @ModelAttribute CommentRequest commentRequest, @PathVariable Long commentId) {
        this.commentService.update(commentRequest, commentId);

        return "redirect:/news/articles/article/" + articleId;
    }


}
