package egor.pantushov.newsservice.exeption;

public class CommentNotFoundException extends NewsException {
    public CommentNotFoundException(Long id) {
        super(String.format("Комментарий с id:%d не найден", id));
    }
}
