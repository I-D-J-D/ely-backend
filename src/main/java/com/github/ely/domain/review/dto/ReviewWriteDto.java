package com.github.ely.domain.review.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewWriteDto {
    private String military_id;
    private String comment;
    private double star_rating;
}
