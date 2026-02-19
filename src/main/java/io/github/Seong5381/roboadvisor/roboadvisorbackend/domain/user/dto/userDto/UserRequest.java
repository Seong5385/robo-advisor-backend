package io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.dto.userDto;

import lombok.*;

@Getter
@AllArgsConstructor
@Builder
public class UserRequest {
    private String userId;
    private String name;
    private String email;
    private String phone;
    private Integer age;
    private String address;
}
