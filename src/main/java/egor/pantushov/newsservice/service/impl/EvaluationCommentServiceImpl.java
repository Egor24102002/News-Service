package egor.pantushov.newsservice.service.impl;


import egor.pantushov.newsservice.dto.response.CommentResponse;
import egor.pantushov.newsservice.entity.*;
import egor.pantushov.newsservice.exeption.ArticleNotFoundException;


import egor.pantushov.newsservice.exeption.UserNotFoundException;
import egor.pantushov.newsservice.mapper.CommentMapper;
import egor.pantushov.newsservice.repository.*;
import egor.pantushov.newsservice.service.EvaluationCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EvaluationCommentServiceImpl implements EvaluationCommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final EvaluationCommentRepository evaluationCommentRepository;
    @Override
    public CommentResponse addEvaluationCommentLike(Long commentId, Principal principal) {
        User user=userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UserNotFoundException(principal.getName()));
        Optional <EvaluationComment> evaluationComment=isHasEvaluationComment(commentId,user.getUserId());
        if (evaluationComment.isPresent()){
            if (evaluationComment.get().getType()==Type.LIKE)
            {
                evaluationCommentRepository.delete(evaluationComment.get());
                return null;
            }
            evaluationCommentRepository.delete(evaluationComment.get());
        }
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ArticleNotFoundException(commentId));
        EvaluationComment evaluation = new EvaluationComment();
        evaluation.setComment(comment);
        evaluation.setType(Type.LIKE);
        evaluation.setUser(user);
        evaluationCommentRepository.save(evaluation);
        comment.addEvaluationsComments(evaluation);
        user.addEvaluationsComments(evaluation);
        return CommentMapper.getCommentResponse(comment);

    }


    @Override
    public CommentResponse addEvaluationCommentDislike(Long commentId, Principal principal) {
        User user=userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UserNotFoundException(principal.getName()));
        Optional <EvaluationComment> evaluationComment=isHasEvaluationComment(commentId,user.getUserId());
        if (evaluationComment.isPresent()){
            if (evaluationComment.get().getType()==Type.DISLIKE)
            {
                evaluationCommentRepository.delete(evaluationComment.get());
                return null;
            }
            evaluationCommentRepository.delete(evaluationComment.get());
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

    public Optional<EvaluationComment> isHasEvaluationComment(Long commentId,Long userId){
        Optional<EvaluationComment> optionalEvaluationComment= evaluationCommentRepository.findEvaluationCommentByUserIdArticleId(commentId,userId);
        return optionalEvaluationComment;
    }




}
