package io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.service;

import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.dto.surveyDto.SurveyScoreRequest;
import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.entry.User;
import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.entry.UserSurvey;
import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.repository.SurveyRepository;
import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserSurveyService {
    private final SurveyRepository surveyRepository;
    private final UserRepository userRepository;

    public void submitSurvey(String userId, SurveyScoreRequest scoreRequest) {
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다"));
        int totalScore = 0;
        if(!surveyRepository.existsByUser(user)) {
            totalScore = scoreRequest.getAnswers().stream().mapToInt(Integer::intValue).sum();
        }


        user.updateRiskType(scoreRequest.chooseRiskType(totalScore));




    }
}
