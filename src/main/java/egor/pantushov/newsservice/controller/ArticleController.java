package egor.pantushov.newsservice.controller;

import egor.pantushov.newsservice.entity.Article;
import egor.pantushov.newsservice.payload.NewArticlePayload;
import egor.pantushov.newsservice.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("news/articles")
public class ArticleController {
    private final ArticleService articleService;
    @GetMapping()
    public String getArticles(Model model){
     model.addAttribute("articles",this.articleService.findAllArticles());
        return "news/articles/list";
    }
    @GetMapping("create")
    public String getNewArticle(){
        return "news/articles/new_article";
    }

    @PostMapping("create")
    public String createProduct(NewArticlePayload newArticlePayload){
        Article article=this.articleService.createArticle(newArticlePayload.title(),newArticlePayload.content());
        return "redirect:/news/articles";
    }
    @GetMapping("{productId:\\d+}")
    public String getProduct(@PathVariable int productId,Model model){
      model.addAttribute("article",this.articleService.findArticle(productId).orElseThrow());
        return "news/articles/article";
    }

}
