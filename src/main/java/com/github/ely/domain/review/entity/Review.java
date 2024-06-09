package com.github.ely.domain.review.entity;

import com.github.ely.domain.review.dto.ReviewWriteDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String comment;

    @Column(name = "military_id")
    private String militaryId;

    @Column(name = "star_rating")
    private double starRating;

    public static Review toEntity(ReviewWriteDto reviewWriteDto) {
        return Review.builder()
                .comment(reviewWriteDto.getComment())
                .build();
    }
}
