package io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.repository;

import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.entry.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUserId(String userId);
    boolean existsByUserId(String userId);
    boolean existsByEmail(String email);
}
