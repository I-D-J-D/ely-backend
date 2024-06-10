package com.github.ely.domain.auth;

import com.github.ely.domain.member.MemberRepository;
import com.github.ely.domain.member.entity.Member;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final HttpSession httpSession;


    @Override
    public UserDetails loadUserByUsername(String militaryId) throws UsernameNotFoundException {


        Optional<Member> member = memberRepository.findByMilitaryId(militaryId);

        if (member == null) {
            throw new UsernameNotFoundException("사용자없음");
        } else {
            httpSession.setAttribute("nickname", member.get().getNickname());
            httpSession.setAttribute("military_id", member.get().getMilitaryId());
            return new CustomUserDetails(member.get());
        }


    }
}
