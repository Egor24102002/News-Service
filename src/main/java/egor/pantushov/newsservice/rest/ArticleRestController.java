package egor.pantushov.newsservice.rest;

import egor.pantushov.newsservice.dto.request.ArticleRequest;
import egor.pantushov.newsservice.dto.response.ArticleResponse;
import egor.pantushov.newsservice.service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ArticleRestController {
    private final ArticleService articleService;
    @GetMapping()
    public ResponseEntity<List<ArticleResponse>> getAllArticles(){
        List<ArticleResponse> articleResponses=articleService.findAllArticles();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(articleResponses);
    }


    @PostMapping
    public ResponseEntity<ArticleResponse> createArticle(Principal principal, @RequestBody @Valid ArticleRequest articleRequest){
        ArticleResponse articleResponse=this.articleService.createArticle(principal,articleRequest);
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(articleResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponse> getArticle(@PathVariable ("id") Long id){
        ArticleResponse articleResponse=this.articleService.findArticle(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(articleResponse);
    }


}
