package io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.service;

import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.dto.userDto.UserRequest;
import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.dto.userDto.UserResponse;
import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.entry.User;
import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.repository.UserRepository;
import io.github.Seong5381.roboadvisor.roboadvisorbackend.global.type.Role;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserProfileService {
    private final UserRepository userRepository;

    public UserResponse userProfile(String userId) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));

        return UserResponse.builder()
                .id(user.getId())
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhoneNum())
                .age(user.getAge())
                .address(user.getAddress())
                .role(Role.USER)
                .tendency(user.getTendency())
                .build();
    }

    public UserRequest update(String userId) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다"));
    }
}
