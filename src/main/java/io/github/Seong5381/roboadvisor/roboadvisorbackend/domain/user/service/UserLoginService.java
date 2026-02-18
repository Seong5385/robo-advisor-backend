package io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.service;

import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.entry.User;
import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.repository.UserRepository;
import io.github.Seong5381.roboadvisor.roboadvisorbackend.global.config.JwtProvider;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLoginService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    public String login(String userId, String password) {
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new IllegalArgumentException("유저 없음"));
        if(!passwordEncoder.matches(password, user.getPassword())) throw new IllegalArgumentException("비밀번호 틀림");
        return jwtProvider.generateToken(user.getUserId());
    }
}
