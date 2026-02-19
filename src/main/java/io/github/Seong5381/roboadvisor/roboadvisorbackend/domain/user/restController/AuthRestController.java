package io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.restController;

import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.dto.userDto.UserLoginRequest;
import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.dto.userDto.UserRegisterRequest;
import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.service.UserLoginService;
import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.service.UserRegisterService;
import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.service.UserSurveyService;
import io.github.Seong5381.roboadvisor.roboadvisorbackend.global.common.ApiResponses;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roboAdvisor/auth")
@RequiredArgsConstructor
public class AuthRestController {
    private final UserRegisterService userRegisterService;
    private final UserLoginService userLoginService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponses<String>> registerUser(@RequestBody UserRegisterRequest request) {
        userRegisterService.register(
                request.getUserId(),
                request.getPassword(),
                request.getName(),
                request.getEmail(),
                request.getPhoneNum(),
                request.getAge(),
                request.getAddress()
        );

        return ResponseEntity.ok(ApiResponses.success("회원가입 성공"));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponses<String>> login(@RequestBody UserLoginRequest request) {
        String token = userLoginService.login(request.getUserId(), request.getPassword());
        return ResponseEntity.ok(ApiResponses.success(token));
    }

    @PostMapping("/logout")
    public ResponseEntity<ApiResponses<String>> logout(HttpServletResponse response) {
        userLoginService.logout(response);
        return ResponseEntity.ok(ApiResponses.success("로그아웃 완료"));
    }

}
