package egor.pantushov.newsservice.rest;

import egor.pantushov.newsservice.dto.request.ArticleRequest;
import egor.pantushov.newsservice.dto.response.ArticleResponse;
import egor.pantushov.newsservice.service.AnsichtenService;
import egor.pantushov.newsservice.service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ArticleRestController {
    private final ArticleService articleService;
    private final AnsichtenService ansichtenService;


    @PreAuthorize("hasAnyAuthority('EDITOR','ADMIN')")
    @PostMapping("/new_article")
    public ResponseEntity<ArticleResponse> createArticle(@Valid @RequestBody ArticleRequest articleRequest, Principal principal){
        ArticleResponse articleResponse=this.articleService.createArticle(principal,articleRequest);
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(articleResponse);
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<ArticleResponse> getArticle(@PathVariable ("articleId") Long articleId,Principal principal){
        ArticleResponse articleResponse=this.articleService.findArticle(articleId);
        this.ansichtenService.addAnsichten(articleId,principal);
        return  ResponseEntity.status(HttpStatus.OK)
                .body(articleResponse);
    }

    @GetMapping("/sport")
    public ResponseEntity<List<ArticleResponse>> getSportArticles(){
        List <ArticleResponse> articleResponses=this.articleService.findSportArticles();
        return  ResponseEntity.status(HttpStatus.OK)
                .body(articleResponses);
    }

    @GetMapping("/war")
    public ResponseEntity<List<ArticleResponse>> getWarArticles(){
        List <ArticleResponse> articleResponses=this.articleService.findWarArticles();
        return  ResponseEntity.status(HttpStatus.OK)
                .body(articleResponses);
    }

    @GetMapping("/politic")
    public ResponseEntity<List<ArticleResponse>> getPoliticArticles(){
        List <ArticleResponse> articleResponses=this.articleService.findPoliticArticles();
        return  ResponseEntity.status(HttpStatus.OK)
                .body(articleResponses);
    }

    @GetMapping("/culture")
    public ResponseEntity<List<ArticleResponse>> getCultureArticles(){
        List <ArticleResponse> articleResponses=this.articleService.findCultureArticles();
        return  ResponseEntity.status(HttpStatus.OK)
                .body(articleResponses);
    }

    @GetMapping("/other")
    public ResponseEntity<List<ArticleResponse>> getOtherArticles( ){
        List <ArticleResponse> articleResponses=this.articleService.findOtherArticles();
        return  ResponseEntity.status(HttpStatus.OK)
                .body(articleResponses);
    }

    @GetMapping("/global")
    public ResponseEntity<List<ArticleResponse>> getGlobalArticles( ){
        List <ArticleResponse> articleResponses=this.articleService.findGlobalArticles();
        return  ResponseEntity.status(HttpStatus.OK)
                .body(articleResponses);
    }

    @GetMapping("")
    public ResponseEntity<List<ArticleResponse>> getPopularArticles( ){
        List <ArticleResponse> articleResponses=this.articleService.getPopularArticles();
        return  ResponseEntity.status(HttpStatus.OK)
                .body(articleResponses);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/verifications")
    public ResponseEntity<List<ArticleResponse>> getVerificationArticles( ){
        List <ArticleResponse> articleResponses=this.articleService.getVerificationsArticle();
        return  ResponseEntity.status(HttpStatus.OK)
                .body(articleResponses);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/verifications/{articleId:\\d+}")
    public  ResponseEntity<ArticleResponse> getVerificationArticle(@PathVariable ("articleId")  Long articleId){
    ArticleResponse articleResponse=this.articleService.findArticle(articleId);
        return  ResponseEntity.status(HttpStatus.OK)
                .body(articleResponse);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PutMapping("/verifications/{articleId:\\d+}")
    public  ResponseEntity<ArticleResponse> approveArticle(@PathVariable ("articleId") Long articleId){
       ArticleResponse articleResponse= this.articleService.approveArticle(articleId);
        return  ResponseEntity.status(HttpStatus.OK)
                .body(articleResponse);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @DeleteMapping("/{articleId:\\d+}")
    public ResponseEntity<String> deleteArticle(@PathVariable  ("articleId") Long articleId){
        this.articleService.deleteArticle(articleId);
        return ResponseEntity.ok(String.format("Статья с id: %d удалена", articleId));
    }

}