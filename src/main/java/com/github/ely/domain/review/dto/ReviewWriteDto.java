package com.github.ely.domain.review.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReviewWriteDto {
    private String military_id;
    private String shopName;
    private String address;
    private String nickname;
    private String comment;
    private Integer star;
}
