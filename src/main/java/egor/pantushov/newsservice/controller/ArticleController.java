package egor.pantushov.newsservice.controller;

import egor.pantushov.newsservice.dto.request.ArticleRequest;
import egor.pantushov.newsservice.dto.request.CommentRequest;
import egor.pantushov.newsservice.dto.response.CommentResponse;
import egor.pantushov.newsservice.entity.Category;
import egor.pantushov.newsservice.service.AnsichtenService;
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
private final AnsichtenService ansichtenService;
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
    public String getArticle(@PathVariable Long articleId,Model model,Principal principal,@ModelAttribute("commentRequest") CommentRequest commentRequest){
      model.addAttribute("articleResponse",this.articleService.findArticle(articleId));
      model.addAttribute("commentRequest",commentRequest);
        this.ansichtenService.addAnsichten(articleId,principal);
        return "news/articles/article";
    }

    @GetMapping("sport")
    public String getSportArticles(Model model){
        model.addAttribute("articlesResponse",this.articleService.findSportArticles());
        return "news/articles/list";
    }

    @GetMapping("war")
    public String getWarArticles(Model model){
        model.addAttribute("articlesResponse",this.articleService.findWarArticles());
        return "news/articles/list";
    }

    @GetMapping("politic")
    public String getPoliticArticles(Model model){
        model.addAttribute("articlesResponse",this.articleService.findPoliticArticles());
        return "news/articles/list";
    }

    @GetMapping("culture")
    public String getCultureArticles(Model model){
        model.addAttribute("articlesResponse",this.articleService.findCultureArticles());
        return "news/articles/list";
    }

    @GetMapping("other")
    public String getOtherArticles(Model model){
        model.addAttribute("articlesResponse",this.articleService.findOtherArticles());
        return "news/articles/list";
    }

    @GetMapping("global")
    public String getGlobalArticles(Model model){
        model.addAttribute("articlesResponse",this.articleService.findGlobalArticles());
        return "news/articles/list";
    }

    @GetMapping("")
    public String getPopularArticles(Model model){
        model.addAttribute("articlesResponse",this.articleService.getPopularArticles());
        return "news/articles/list";
    }

    @GetMapping("verifications")
    public String getVerificationArticle(Model model){
        model.addAttribute("articlesResponse",this.articleService.getVerificationArticle());
        return "news/articles/list";
    }

}
