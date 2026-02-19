package io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.restController;

import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.dto.userDto.UserResponse;
import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.entry.User;
import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.repository.UserRepository;
import io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.service.UserProfileService;
import io.github.Seong5381.roboadvisor.roboadvisorbackend.global.common.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roboAdvisor/users")
public class UserRestController {
    private final UserProfileService userProfileService;

    @GetMapping("/{userId}")
    public UserResponse userProfile(@PathVariable String userId) {
        return userProfileService.userProfile(userId);
    }

}
