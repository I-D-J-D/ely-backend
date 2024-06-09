package com.github.ely.domain.member.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class LoginDto {

    @Pattern(regexp = "\\d{2}-\\d{8}")
    private String military_id;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,20}$")
    private String password;
}
