package com.github.ely.domain.member;

import com.github.ely.domain.member.dto.LoginDto;
import com.github.ely.domain.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public String signup(@ModelAttribute MemberDto memberDto) {
        memberService.save(memberDto);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDto loginDto) {
        memberService.login(loginDto);
        return "redirect:/main";
    }
}
