package com.github.ely.domain.member;

import com.github.ely.domain.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public String signup(@ModelAttribute MemberDto memberDto) {
        memberService.save(memberDto);
        return "redirect:/login";
    }

    @GetMapping("/ok")
    @ResponseBody
    public String ok() {
        return "ok";
    }

    @GetMapping("/del")
    @ResponseBody
    public String del() {
        return "del";
    }
}
