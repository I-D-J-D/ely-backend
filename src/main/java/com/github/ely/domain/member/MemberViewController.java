package com.github.ely.domain.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberViewController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/re")
    public String re() {
        return "review";
    }

    @GetMapping("/rew")
    public String rew() {
        return "review-write";
    }
}
