package com.github.ely.domain.auth;

import com.github.ely.domain.member.MemberRepository;
import com.github.ely.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String militaryId) throws UsernameNotFoundException {
        Member member = memberRepository.findByMilitaryId(militaryId)
                .orElseThrow(() -> new RuntimeException("militaryId not found"));

        return new CustomUserDetails(member);
    }
}
