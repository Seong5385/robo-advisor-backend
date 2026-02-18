package io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.service;

import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.dto.userDto.UserResponse;
import io.github.Seong5381.roboadvisor.roboadvisorbackend.global.type.Role;
import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.entry.User;
import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserRegisterService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponse findById(Long id) {
        User user = userRepository.findById(id)
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
                .build();
    }

    public Long register(String userId, String password, String name, String email, String phoneNum, Integer age, String addr) {
        if(userRepository.existsByUserId(userId)) {
            throw new IllegalArgumentException("아이디가 존재합니다");
        }

        if(userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("이메일이 존재합니다");
        }

        String encodedPassword = passwordEncoder.encode(password);

        User user = User.builder()
                .userId(userId)
                .password(encodedPassword)
                .name(name)
                .email(email)
                .phoneNum(phoneNum)
                .age(age)
                .address(addr)
                .roleType(Role.USER)
                .build();

        userRepository.save(user);

        return user.getId();
    }
}
