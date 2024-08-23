package egor.pantushov.newsservice.repository;

import aj.org.objectweb.asm.commons.Remapper;
import egor.pantushov.newsservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);

}
