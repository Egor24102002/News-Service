package egor.pantushov.newsservice.service.impl;

import egor.pantushov.newsservice.dto.request.CommentRequest;
import egor.pantushov.newsservice.dto.response.CommentResponse;
import egor.pantushov.newsservice.entity.Article;
import egor.pantushov.newsservice.entity.Comment;
import egor.pantushov.newsservice.entity.Role;
import egor.pantushov.newsservice.entity.User;
import egor.pantushov.newsservice.exeption.ArticleNotFoundException;
import egor.pantushov.newsservice.exeption.CommentNotFoundException;
import egor.pantushov.newsservice.exeption.CommentSubmittedException;
import egor.pantushov.newsservice.exeption.UserNotFoundException;
import egor.pantushov.newsservice.mapper.CommentMapper;
import egor.pantushov.newsservice.repository.ArticleRepository;
import egor.pantushov.newsservice.repository.CommentRepository;
import egor.pantushov.newsservice.repository.UserRepository;
import egor.pantushov.newsservice.service.CommentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    @Transactional
    @Override
    public CommentResponse createComment(Principal principal, CommentRequest commentRequest, Long id) {
        Comment comment = CommentMapper.getComment(commentRequest);
        User user = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UserNotFoundException(principal.getName()));
        comment.setUser(user);
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new ArticleNotFoundException(id));
        comment.setArticle(article);
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
    public CommentResponse update(CommentRequest commentRequest, Long commentId) {
        Comment comment = this.commentRepository.findById(commentId).orElseThrow(() -> new CommentNotFoundException(commentId));
        comment.setText(commentRequest.getText());
        return CommentMapper.getCommentResponse(this.commentRepository.save(comment));
    }

    @Transactional
    @Override
    public CommentResponse getNewCommentForUpdate(Long commentId, Principal principal) {
        User user = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UserNotFoundException(principal.getName()));
        Comment comment = this.commentRepository.findById(commentId).orElseThrow(() -> new CommentNotFoundException(commentId));
        if ((!Objects.equals(comment.getUser().getUserId(), user.getUserId())) && (user.getRole() != Role.ADMIN))
            throw new CommentSubmittedException(commentId, user.getUsername());
        return CommentMapper.getCommentResponse(comment);
    }

    @Transactional
    @Override
    public CommentResponse deleteComment(Principal principal, Long commentId) {
        Comment comment = this.commentRepository.findById(commentId).orElseThrow(() -> new CommentNotFoundException(commentId));
        User user = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UserNotFoundException(principal.getName()));

        if ((!Objects.equals(comment.getUser().getUserId(), user.getUserId())) && (user.getRole() != Role.ADMIN))
            throw new CommentSubmittedException(commentId, user.getUsername());


        comment.setIsDeleted(Boolean.TRUE);
        commentRepository.save(comment);

        return CommentMapper.getCommentResponse(comment);
    }
}
