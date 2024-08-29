package egor.pantushov.newsservice.mapper;

import egor.pantushov.newsservice.dto.request.CommentRequest;
import egor.pantushov.newsservice.dto.response.CommentResponse;
import egor.pantushov.newsservice.dto.response.UserResponse;
import egor.pantushov.newsservice.entity.Comment;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CommentMapper {
    public static CommentResponse getCommentResponse(Comment comment) {
        UserResponse userResponse= Optional.ofNullable(comment.getUser())
                .map(UserMapper::getUserResponse).orElse(null);
        String date=comment.getDateOfComment().toString();

        return new CommentResponse( comment.getText(),  date.substring(0,date.length()-5),userResponse,comment.getCommentId(),comment.getArticle().getArticleId())
                ;
    }

    public static CommentRequest getCommentRequest(CommentResponse commentResponse){
        return new CommentRequest(commentResponse.getCommentId(), commentResponse.getText(),commentResponse.getArticleId());
    }

    public static Comment getComment(Comment comment, CommentRequest commentRequest) {
        comment.setText(commentRequest.getText());

        return comment;
    }


}
