package com.github.ely.domain.member;

import com.github.ely.domain.member.dto.LoginDto;
import com.github.ely.domain.member.dto.MemberDto;
import com.github.ely.domain.member.entity.Member;
import com.github.ely.global.JwtUtil;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void save(MemberDto memberDto) {
        Member member = Member.toEntity(memberDto);

        member.passwordEncode(bCryptPasswordEncoder);

        memberRepository.save(member);
    }

    public String login(LoginDto loginDto) {

        log.info("username: {}", loginDto.getMilitary_id());
        log.info("password: {}", loginDto.getPassword());

        // 1. 회원 정보 및 비밀번호 조회
        Member member = memberRepository.findByMilitaryId(loginDto.getMilitary_id()).orElseThrow(
                () -> new RuntimeException("member not found"));
        String encodedPassword = (member == null) ? "" : member.getPassword();

        // 2. 회원 정보 및 비밀번호 체크
        if (!bCryptPasswordEncoder.matches(loginDto.getPassword(), encodedPassword)) {
            throw new RuntimeException("wrong password");
        }

        return JwtUtil.createJwt(loginDto.getMilitary_id());
    }
}
