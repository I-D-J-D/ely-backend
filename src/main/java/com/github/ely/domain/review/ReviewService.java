package com.github.ely.domain.review;

import com.github.ely.domain.review.dto.ReviewWriteDto;
import com.github.ely.domain.review.entity.Review;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public void save(ReviewWriteDto review) {
        Review reviewEntity = Review.toEntity(review);
        log.info("save reviewComment: {}", review.getComment());
        log.info("save review: {}", reviewEntity);
        reviewRepository.save(reviewEntity);
    }
}
