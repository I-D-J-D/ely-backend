package com.github.ely.domain.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReviewViewController {

    @GetMapping("/re")
    public String re() {
        return "review";
    }

    @GetMapping("/rew")
    public String rew() {
        return "review-write";
    }
}
