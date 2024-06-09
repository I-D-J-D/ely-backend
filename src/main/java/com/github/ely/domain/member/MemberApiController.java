package com.github.ely.domain.member;

import com.github.ely.domain.member.dto.LoginDto;
import com.github.ely.domain.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberApiController {

    private final MemberService memberService;

    private String n;

    @PostMapping("/signup")
    public String signup(@ModelAttribute MemberDto memberDto) {
        memberService.save(memberDto);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String loginSuccess(@ModelAttribute LoginDto loginDto) {
        n = memberService.login(loginDto);
        log.info("login success");
        log.info(n);
        return memberService.login(loginDto);
    }

    @GetMapping("/loginSuccess")
    @ResponseBody
    public String ok() {
        return "a" + n;
    }

//    @GetMapping("/ok")
//    @ResponseBody
//    public String ok(LoginDto loginDto) {
//        return "ok";
//    }

    @GetMapping("/del")
    @ResponseBody
    public String del() {
        return "del";
    }
}
