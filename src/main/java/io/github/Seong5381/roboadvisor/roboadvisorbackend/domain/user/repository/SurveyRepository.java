package io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.repository;

import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.entry.User;
import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.entry.UserSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SurveyRepository extends JpaRepository<UserSurvey, Long> {
    Optional<UserSurvey> findTopByUserOrderByCreatedAtDesc(User user);
    boolean existsByUser(User user);
}
