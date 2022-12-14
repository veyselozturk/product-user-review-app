package com.veyselozturk.productuserreviewapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponse {
    private Long id ;
    private String review;
    private Date reviewDate;
    private Long product_id;
    private Long user_id;
}
