package com.github.ely.domain;

import com.github.ely.domain.review.ReviewService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class ViewController {


    final private ReviewService reviewService;
    final private HttpSession session;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/re")
    public String re(@RequestParam String shop, @RequestParam String address, Model model) {

        String shopName = shop;
        String nickname = (String) session.getAttribute("nickname");
        String military_id = (String) session.getAttribute("military_id");


        model.addAttribute("shopName", shopName);
        model.addAttribute("nickname", nickname);
        model.addAttribute("military_id", military_id);
        model.addAttribute("address", address);


        model.addAttribute("list", reviewService.load(shop, address));
        System.out.println();

        return "review";
    }

    @GetMapping("/rew")
    public String rew(@RequestParam String shop, @RequestParam String address, Model model) {

        String shopName = shop;
        String nickname = (String) session.getAttribute("nickname");
        String military_id = (String) session.getAttribute("military_id");


        model.addAttribute("shopName", shopName);
        model.addAttribute("nickname", nickname);
        model.addAttribute("military_id", military_id);
        model.addAttribute("address", address);


        return "review-write";
    }

    @GetMapping("/fp")
    public String fp() {
        return "find_pass";
    }

    @GetMapping("/")
    public String index() {
        System.out.println();
        return "index";
    }
}
