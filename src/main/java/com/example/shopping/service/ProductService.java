package com.example.shopping.service;

import com.example.shopping.dto.request.ProductRequest;
import com.example.shopping.dto.request.ReviewRequest;
import com.example.shopping.dto.request.UserRequest;
import com.example.shopping.dto.response.ProductResponse;
import com.example.shopping.dto.response.ReviewResponse;
import com.example.shopping.dto.response.UserResponse;
import com.example.shopping.entity.Review;
import com.example.shopping.repository.ProductRepository;
import com.example.shopping.repository.ReviewRepository;
import com.example.shopping.repository.UserRepository;
import org.springframework.stereotype.Service;

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
