package com.example.shopping.service;

import com.example.shopping.dto.request.ProductRequest;
import com.example.shopping.dto.request.ReviewRequest;
import com.example.shopping.dto.response.ReviewResponse;
import com.example.shopping.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ReviewResponse> findReviewsByProductID(ProductRequest request);
    List<ReviewResponse> findReviewsByDateRangeAndProductID(ProductRequest request);
    List<ReviewResponse> findReviewsByUserID(ReviewRequest request);
    List<ReviewResponse> findReviewsByDateRangeAndUserID(ReviewRequest request);
    List<ReviewResponse> findProductsByExpirationAfter(ProductRequest request);
    List<ReviewResponse> findProductsByExpirationBefore(ProductRequest request);




}
