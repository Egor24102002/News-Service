package egor.pantushov.newsservice.mapper;

import egor.pantushov.newsservice.dto.request.CommentRequest;
import egor.pantushov.newsservice.dto.response.CommentResponse;
import egor.pantushov.newsservice.dto.response.EvaluationResponse;
import egor.pantushov.newsservice.dto.response.UserResponse;
import egor.pantushov.newsservice.entity.Comment;
import org.springframework.stereotype.Component;

import java.util.Optional;


public class CommentMapper {
    public static CommentResponse getCommentResponse(Comment comment) {
        UserResponse userResponse = Optional.ofNullable(comment.getUser())
                .map(UserMapper::getUserResponse).orElse(null);
        String date = comment.getDateOfComment().toString();
        EvaluationResponse evaluationCommentResponse = Optional.ofNullable(comment.getEvaluationComments())
                .map(EvaluationMapper::getEvaluationResponseByComment).orElse(null);
        return new CommentResponse(comment.getText(), date.substring(0, date.length() - 5), userResponse, comment.getCommentId(), comment.getArticle().getArticleId(), evaluationCommentResponse)
                ;
    }

    public static CommentRequest getCommentRequest(CommentResponse commentResponse) {
        return new CommentRequest(commentResponse.getText());
    }

    public static Comment getComment(Comment comment, CommentRequest commentRequest) {
        comment.setText(commentRequest.getText());
        return comment;
    }


}
