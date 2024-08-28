package egor.pantushov.newsservice.exeption;

public class UserNotFoundException extends NewsException{
    public UserNotFoundException(String username) {
        super(String.format("Пользователь с логином:%d не найдена",username));
    }
}
