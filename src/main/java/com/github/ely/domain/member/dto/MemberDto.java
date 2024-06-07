package com.github.ely.domain.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private String military_id;
    private String password;
    private String nickname;
    private String level;
    private String phone;
}
