package io.github.Seong5381.roboadvisor.roboadvisorbackend.domain.user.entry;

import io.github.Seong5381.roboadvisor.roboadvisorbackend.global.entry.BaseTimeEntry;
import io.github.Seong5381.roboadvisor.roboadvisorbackend.global.type.RiskType;
import io.github.Seong5381.roboadvisor.roboadvisorbackend.global.type.Role;
import jakarta.persistence.*;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class User extends BaseTimeEntry {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 20)
    private String phoneNum;

    private Integer age;

    private String address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role roleType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RiskType personality;

    @OneToMany(mappedBy = "user")
    private List<UserSurvey> surveyResults = new ArrayList<>();

    public void updateProfile(String name, String email, String phone, String address) {
        this.name = name;
        this.email = email;
        this.phoneNum = phone;
        this.address = address;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

}
