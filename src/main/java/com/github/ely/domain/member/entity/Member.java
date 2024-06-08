package com.github.ely.domain.member.entity;

import com.github.ely.domain.member.dto.MemberDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member")
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @Column(name = "military_id")
    private String militaryId;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "level")
    private String level;

    @Column(name = "nickname")
    private String nickname;

    public void passwordEncode(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }

    public static Member toEntity(MemberDto memberDto) {
        return Member.builder()
                .militaryId(memberDto.getMilitary_id())
                .password(memberDto.getPassword())
                .phone(memberDto.getPhone())
                .level(memberDto.getLevel())
                .nickname(memberDto.getNickname())
                .build();
    }
}
