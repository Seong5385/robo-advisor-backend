package io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.dto.userDto;

import io.github.Seong5381.roboadvisor.roboadvisorbackend.global.type.Role;
import lombok.*;

@Getter
@AllArgsConstructor
@Builder
public class UserResponse {
    private Long id;
    private String userId;
    private String name;
    private String email;
    private String phone;
    private Integer age;
    private String address;
    private Role role;
}
