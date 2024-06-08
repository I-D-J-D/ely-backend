package com.github.ely.domain.member;

import com.github.ely.domain.member.dto.LoginDto;
import com.github.ely.domain.member.dto.MemberDto;
import com.github.ely.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void save(MemberDto memberDto) {
        Member member = Member.toEntity(memberDto);

        member.passwordEncode(bCryptPasswordEncoder);

        memberRepository.save(member);
    }

    public void login(LoginDto loginDto) {

        // 1. 회원 정보 및 비밀번호 조회
        Member member = memberRepository.findByMilitary_id(loginDto.getMilitary_id()).orElseThrow(
                () -> new RuntimeException("member not found"));
        String encodedPassword = (member == null) ? "" : member.getPassword();

        // 2. 회원 정보 및 비밀번호 체크
        if (!bCryptPasswordEncoder.matches(loginDto.getPassword(), encodedPassword)) {
            throw new RuntimeException("wrong password");
        }

        // 3. 회원 응답 객체에서 비밀번호를 제거한 후 회원 정보 리턴
//        member.clearPassword();
    }
}
