package egor.pantushov.newsservice.service.impl;

import egor.pantushov.newsservice.dto.request.CommentRequest;
import egor.pantushov.newsservice.dto.response.ArticleResponse;
import egor.pantushov.newsservice.dto.response.CommentResponse;
import egor.pantushov.newsservice.entity.Article;
import egor.pantushov.newsservice.entity.Comment;
import egor.pantushov.newsservice.entity.User;
import egor.pantushov.newsservice.enums.Status;
import egor.pantushov.newsservice.exeption.ArticleNotFoundException;
import egor.pantushov.newsservice.exeption.CommentNotFoundException;
import egor.pantushov.newsservice.exeption.UserNotFoundException;
import egor.pantushov.newsservice.mapper.ArticleMapper;
import egor.pantushov.newsservice.mapper.CommentMapper;
import egor.pantushov.newsservice.repository.ArticleRepository;
import egor.pantushov.newsservice.repository.CommentRepository;
import egor.pantushov.newsservice.repository.UserRepository;
import egor.pantushov.newsservice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;
    @Override
    public CommentResponse createComment(Principal principal, CommentRequest commentRequest,Long id) {
        Comment comment=new Comment();
       User user=userRepository.findByUsername(principal.getName())
               .orElseThrow(() -> new UserNotFoundException(principal.getName()));
            comment.setUser(user);
        Article article=articleRepository.findById(id)
                .orElseThrow(() -> new ArticleNotFoundException(id));
            comment.setArticle(article);

        CommentMapper.getComment(comment, commentRequest);
        user.addComment(comment);
        article.addComment(comment);
        this.commentRepository.save(comment);
        return CommentMapper.getCommentResponse(comment);
    }

    @Override
    public CommentResponse findComment(Long commentId) {
        return this.commentRepository.findById(commentId).map(CommentMapper::getCommentResponse)
                .orElseThrow(() -> new CommentNotFoundException(commentId));
    }

    @Override
    public CommentResponse update(CommentRequest commentRequest) {
   Comment comment=  this.commentRepository.findById(commentRequest.getCommentId()). orElseThrow(() -> new CommentNotFoundException(commentRequest.getCommentId()));
   comment.setText(commentRequest.getText());
   return  CommentMapper.getCommentResponse(this.commentRepository.save(comment));
    }
}
