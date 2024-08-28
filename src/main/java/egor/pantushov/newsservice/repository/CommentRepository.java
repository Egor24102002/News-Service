package egor.pantushov.newsservice.repository;

import egor.pantushov.newsservice.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {

}
