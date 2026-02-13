package io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginRequest {
    private String userId;
    private String password;
}
