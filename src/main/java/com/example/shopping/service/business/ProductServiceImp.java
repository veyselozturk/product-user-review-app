package com.example.shopping.service.business;

import com.example.shopping.dto.request.ProductRequest;
import com.example.shopping.dto.request.ReviewRequest;
import com.example.shopping.dto.response.ReviewResponse;
import com.example.shopping.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {

    @Override
    public List<ReviewResponse> findReviewsByProductID(ProductRequest request) {
        return null;
    }

    @Override
    public List<ReviewResponse> findReviewsByDateRangeAndProductID(ProductRequest request) {
        return null;
    }

    @Override
    public List<ReviewResponse> findReviewsByUserID(ReviewRequest request) {
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
}
