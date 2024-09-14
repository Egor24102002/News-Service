package egor.pantushov.newsservice.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class CommentSubmittedException extends RuntimeException {
    public CommentSubmittedException(Long id, String username) {
        super(String.format("Комментарий с id:%d не доступен для управления пользователю с именем %s ", id, username));
    }

}
