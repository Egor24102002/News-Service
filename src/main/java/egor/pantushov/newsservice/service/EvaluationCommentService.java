package egor.pantushov.newsservice.service;

import egor.pantushov.newsservice.dto.response.CommentResponse;

import java.security.Principal;

public interface EvaluationCommentService {
    CommentResponse addEvaluationCommentLike(Long commentId, Principal principal);
    CommentResponse addEvaluationCommentDislike(Long commentId, Principal principal);

}
