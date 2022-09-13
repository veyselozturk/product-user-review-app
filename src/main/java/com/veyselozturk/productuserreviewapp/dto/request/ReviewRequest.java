package com.veyselozturk.productuserreviewapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {

    private Long id;
    private String review;
    private Date reviewDate;
    private List<Date> dateRange;
    private Long productId;
    private Long userId;

}
