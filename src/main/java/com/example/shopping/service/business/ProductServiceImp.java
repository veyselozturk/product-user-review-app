package com.example.shopping.service.business;

import com.example.shopping.dto.request.ProductRequest;
import com.example.shopping.dto.request.ReviewRequest;
import com.example.shopping.dto.request.UserRequest;
import com.example.shopping.dto.response.ProductResponse;
import com.example.shopping.dto.response.ReviewResponse;
import com.example.shopping.dto.response.UserResponse;
import com.example.shopping.repository.ProductRepository;
import com.example.shopping.repository.ReviewRepository;
import com.example.shopping.repository.UserRepository;
import com.example.shopping.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {
    @Override
    public List<ReviewResponse> findReviewsByProductID(Long productId) {
        return null;
    }
    @Override
    public List<ReviewResponse> findReviewsByDateRangeAndProductID(ProductRequest request) {
        return null;
    }
    @Override
    public List<ReviewResponse> findReviewsByUserID(Long userId) {
        return null;
    }
    @Override
    public List<ReviewResponse> findReviewsByDateRangeAndUserID(ReviewRequest request) {
        return null;
    }
    @Override
    public List<ReviewResponse> findProductsByExpirationAfter(ProductRequest request) {
        return null;
    }
    @Override
    public List<ReviewResponse> findProductsByExpirationBefore(ProductRequest request) {
        return null;
    }
    @Override
    public Optional<UserResponse> createUser(UserRequest request) {
        return Optional.empty();
    }
    @Override
    public Optional<ReviewResponse> createReview(ReviewRequest request) {
        return Optional.empty();
    }
    @Override
    public Optional<ProductResponse> createProduct(ProductRequest request) {
        return Optional.empty();
    }
}
