package egor.pantushov.newsservice.service.impl;


import egor.pantushov.newsservice.dto.response.CommentResponse;
import egor.pantushov.newsservice.entity.*;
import egor.pantushov.newsservice.exeption.ArticleNotFoundException;


import egor.pantushov.newsservice.exeption.CommentNotFoundException;
import egor.pantushov.newsservice.exeption.EvaluationCommentNotFoundException;
import egor.pantushov.newsservice.exeption.UserNotFoundException;
import egor.pantushov.newsservice.mapper.CommentMapper;
import egor.pantushov.newsservice.repository.*;
import egor.pantushov.newsservice.service.EvaluationCommentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class EvaluationCommentServiceImpl implements EvaluationCommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final EvaluationCommentRepository evaluationCommentRepository;

    @Transactional
    @Override
    public CommentResponse addEvaluationCommentLike(Long commentId, Principal principal) {
        User user = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UserNotFoundException(principal.getName()));
        if (evaluationCommentRepository.existsByUserIdAndCommentId(user.getUserId(), commentId)) {
            EvaluationComment evaluationComment = evaluationCommentRepository.findEvaluationCommentByUserIdCommentId(commentId, user.getUserId())
                    .orElseThrow(() -> new EvaluationCommentNotFoundException(commentId));

            if (evaluationComment.getType() == Type.LIKE) {
                evaluationCommentRepository.delete(evaluationComment);
                return null;
            }

            evaluationCommentRepository.delete(evaluationComment);
        }

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentNotFoundException(commentId));

        EvaluationComment evaluation = new EvaluationComment();
        evaluation.setComment(comment);
        evaluation.setType(Type.LIKE);
        evaluation.setUser(user);

        evaluationCommentRepository.save(evaluation);
        comment.addEvaluationsComments(evaluation);
        user.addEvaluationsComments(evaluation);

        return CommentMapper.getCommentResponse(comment);

    }

    @Transactional
    @Override
    public CommentResponse addEvaluationCommentDislike(Long commentId, Principal principal) {
        User user = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UserNotFoundException(principal.getName()));
        if (evaluationCommentRepository.existsByUserIdAndCommentId(user.getUserId(), commentId)) {
            EvaluationComment evaluationComment = evaluationCommentRepository.findEvaluationCommentByUserIdCommentId(commentId, user.getUserId())
                    .orElseThrow(() -> new EvaluationCommentNotFoundException(commentId));

            if (evaluationComment.getType() == Type.DISLIKE) {
                evaluationCommentRepository.delete(evaluationComment);
                return null;
            }

            evaluationCommentRepository.delete(evaluationComment);
        }

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ArticleNotFoundException(commentId));

        EvaluationComment evaluation = new EvaluationComment();
        evaluation.setComment(comment);
        evaluation.setType(Type.DISLIKE);
        evaluation.setUser(user);

        evaluationCommentRepository.save(evaluation);
        comment.addEvaluationsComments(evaluation);
        user.addEvaluationsComments(evaluation);

        return CommentMapper.getCommentResponse(comment);

    }


}
