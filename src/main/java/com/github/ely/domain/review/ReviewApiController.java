package com.github.ely.domain.review;

import com.github.ely.domain.review.dto.ReviewWriteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class ReviewApiController {

    private final ReviewService reviewService;

    @PostMapping("/rew")
    public String rew(@ModelAttribute ReviewWriteDto dto, RedirectAttributes redirectAttributes) {

        redirectAttributes.addAttribute("address", dto.getAddress());
        redirectAttributes.addAttribute("shop", dto.getShopName());

        System.out.println(dto.getStar());

        reviewService.save(dto);
        return "redirect:/re";
    }
}
