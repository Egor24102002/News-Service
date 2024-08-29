package egor.pantushov.newsservice.controller;

import egor.pantushov.newsservice.dto.request.ArticleRequest;
import egor.pantushov.newsservice.dto.request.CommentRequest;
import egor.pantushov.newsservice.dto.response.CommentResponse;
import egor.pantushov.newsservice.entity.Category;
import egor.pantushov.newsservice.service.ArticleService;
import egor.pantushov.newsservice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("news/articles")
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping()
    public String getAllArticles(Model model){
     model.addAttribute("articlesResponse",this.articleService.findAllArticles());
        return "news/articles/list";
    }

    @GetMapping("create")
    public String getNewArticle(Model model,@ModelAttribute("articleRequest") ArticleRequest articleRequest){
        model.addAttribute("articleRequest", articleRequest);
        model.addAttribute("categories", Category.values());
        return "news/articles/new_article";
    }

    @PostMapping("create")
    public String createArticle(@ModelAttribute ArticleRequest articleRequest, Principal principal){
        this.articleService.createArticle(principal,articleRequest);
        return "redirect:/news/articles";
    }

    @GetMapping("{articleId:\\d+}")
    public String getArticle(@PathVariable Long articleId,Model model,@ModelAttribute("commentRequest") CommentRequest commentRequest){
      model.addAttribute("articleResponse",this.articleService.findArticle(articleId));
      model.addAttribute("commentRequest",commentRequest);
        return "news/articles/article";
    }







}
