package egor.pantushov.newsservice.exeption;

public class UserNotFoundException extends NewsException {
    public UserNotFoundException(String username) {
        super(String.format("Пользователь с логином:%s не найдена", username));
    }

    public UserNotFoundException(Long userId) {
        super(String.format("Пользователь с id:%d не найдена", userId));
    }
}
