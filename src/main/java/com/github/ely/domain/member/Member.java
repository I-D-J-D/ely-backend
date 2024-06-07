package com.github.ely.domain.member;

import com.github.ely.domain.member.dto.MemberDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    private String military_id;

    private String password;

    private String phone;

    private String level;

    public static Member toEntity(MemberDto memberDto) {
        return Member.builder()
                .military_id(memberDto.getMilitary_id())
                .password(memberDto.getPassword())
                .phone(memberDto.getPhone())
                .level(memberDto.getLevel())
                .build();
    }
}
