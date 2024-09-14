package egor.pantushov.newsservice.exeption;

public class EvaluationCommentNotFoundException extends NewsException {
    public EvaluationCommentNotFoundException(Long commentId) {
        super(String.format("Вы уже оценили комментарий с id %d", commentId));
    }
}
