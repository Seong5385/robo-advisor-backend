package io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.dto.userDto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegisterRequest {
    private Long id;
    private String userId;
    private String password;
    private String name;
    private String email;
    private String phoneNum;
    private Integer age;
    private String address;
    private String role;
}
