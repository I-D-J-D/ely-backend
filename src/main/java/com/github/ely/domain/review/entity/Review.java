package com.github.ely.domain.review.entity;

import com.github.ely.domain.review.dto.ReviewWriteDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String comment;

    private String shop;

    private String nickname;

    private String address;

    @Column(name = "military_id")
    private String militaryId;

    @Column(name = "star_rating")
    private Integer starRating;

    private String now_date;

    public static Review toEntity(ReviewWriteDto reviewWriteDto) {
        return Review.builder()
                .shop(reviewWriteDto.getShopName())
                .nickname(reviewWriteDto.getNickname())
                .militaryId(reviewWriteDto.getMilitary_id())
                .comment(reviewWriteDto.getComment())
                .starRating(reviewWriteDto.getStar())
                .address(reviewWriteDto.getAddress())
                .now_date(LocalDate.now().toString())
                .build();
    }
}
