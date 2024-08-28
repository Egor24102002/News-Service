package egor.pantushov.newsservice.repository;

import egor.pantushov.newsservice.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<Evaluation,Long> {
}
