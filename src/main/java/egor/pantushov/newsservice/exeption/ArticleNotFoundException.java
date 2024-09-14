package egor.pantushov.newsservice.exeption;

public class ArticleNotFoundException extends NewsException {

    public ArticleNotFoundException(Long id) {
        super(String.format("Статья с id:%d не найдена", id));
    }

}
