package com.veyselozturk.productuserreviewapp.service;

import com.veyselozturk.productuserreviewapp.dto.request.ProductRequest;
import com.veyselozturk.productuserreviewapp.dto.request.ReviewRequest;
import com.veyselozturk.productuserreviewapp.dto.request.UserRequest;
import com.veyselozturk.productuserreviewapp.dto.response.ProductResponse;
import com.veyselozturk.productuserreviewapp.dto.response.ReviewResponse;
import com.veyselozturk.productuserreviewapp.dto.response.UserResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ReviewResponse> findReviewsByProductID(Long productId);
    List<ReviewResponse> findReviewsByDateRangeAndProductID(ReviewRequest request);
    List<ReviewResponse> findReviewsByUserID(Long userId);
    List<ReviewResponse> findReviewsByDateRangeAndUserID(ReviewRequest request);
    List<ProductResponse> findProductsByExpirationAfter(ProductRequest request);
    List<ProductResponse> findProductsByExpirationBefore(ProductRequest request);

    Optional<UserResponse> createUser (UserRequest request);
    Optional<ReviewResponse> createReview (ReviewRequest request);
    Optional<ProductResponse> createProduct (ProductRequest request);


}
