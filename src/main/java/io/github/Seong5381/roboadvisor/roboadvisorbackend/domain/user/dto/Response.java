package io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.dto;

import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.entry.Role;
import lombok.*;

@Getter
@AllArgsConstructor
@Builder
public class Response {
    private Long id;
    private String userId;
    private String name;
    private String email;
    private String phone;
    private Integer age;
    private String address;
    private Role role;
}
