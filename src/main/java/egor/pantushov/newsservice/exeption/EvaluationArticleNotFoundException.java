package egor.pantushov.newsservice.exeption;

public class EvaluationArticleNotFoundException extends NewsException {
    public EvaluationArticleNotFoundException(Long articleId) {
        super(String.format("Вы уже оценили статью с id %d", articleId));
    }
}
