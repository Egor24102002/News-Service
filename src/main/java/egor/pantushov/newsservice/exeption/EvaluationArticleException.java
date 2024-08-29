package egor.pantushov.newsservice.exeption;

public class EvaluationArticleException extends NewsException {
    public EvaluationArticleException(Long articleId) {
        super(String.format("Вы уже оценили статью с id %d", articleId));
    }
}
