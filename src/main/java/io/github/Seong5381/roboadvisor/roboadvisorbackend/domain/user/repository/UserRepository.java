package io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.repository;

import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.entry.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);
    boolean existsByUserId(String userId);
    boolean existsByEmail(String email);
}
