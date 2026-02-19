package io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.dto.surveyDto;

import io.github.Seong5381.roboadvisor.roboadvisorbackend.global.type.RiskType;
import lombok.Getter;
import java.util.List;

@Getter
public class SurveyScoreRequest {
    private List<Integer> answers;

    public RiskType chooseRiskType(int totalScore) {
        if(totalScore > 80)
            return RiskType.AGGRESSIVE;
        else if(totalScore >= 50)
            return RiskType.MODERATE;
        else
            return RiskType.CONSERVATION;
    }
}
