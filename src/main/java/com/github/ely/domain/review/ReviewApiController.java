package com.github.ely.domain.review;

import com.github.ely.domain.review.dto.ReviewWriteDto;
import com.github.ely.domain.review.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ReviewApiController {

    private final ReviewService reviewService;

    @PostMapping("/rew")
    public String rew(@ModelAttribute ReviewWriteDto reviewWriteDto) {
        reviewService.save(reviewWriteDto);
        return "redirect:/re";
    }
}
