package com.example.shopping.controller;

import com.example.shopping.dto.request.ProductRequest;
import com.example.shopping.dto.request.ReviewRequest;
import com.example.shopping.dto.request.UserRequest;
import com.example.shopping.dto.response.ProductResponse;
import com.example.shopping.dto.response.ReviewResponse;
import com.example.shopping.dto.response.UserResponse;
import com.example.shopping.service.ProductService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.Optional;

@RequestScope
@RestController
@RequestMapping("/products")
@Validated
public class ProductController{
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/createUser")
    public Optional<UserResponse> createUser(UserRequest request){
        return productService.createUser(request);
    }
    @PostMapping("/createReview")
    public Optional<ReviewResponse> createUser(ReviewRequest request){
        return productService.createReview(request);
    }
    @PostMapping("/createProduct")
    public Optional<ProductResponse> createUser(ProductRequest request){
        return productService.createProduct(request);
    }
    @GetMapping("/getReviews/{productId}")
    public List<ReviewResponse> findReviewsByProductID(@PathVariable Long productId){
        return productService.findReviewsByProductID(productId);
    }

    @GetMapping("/getReviewsByDateRangeAndProductID")
    public List<ReviewResponse> findReviewsByDateRangeAndProductID(@RequestBody ProductRequest request){
        return productService.findReviewsByDateRangeAndProductID(request);
    }

    @GetMapping("/getReviews/{userId}")
    public List<ReviewResponse> findReviewsByUserID(@PathVariable Long userId){
        return productService.findReviewsByUserID(userId);
    }

    @GetMapping("/getReviewsByDateRangeAndUserID")
    public List<ReviewResponse> findReviewsByDateRangeAndUserID(@RequestBody ReviewRequest request){
        return productService.findReviewsByDateRangeAndUserID(request);
    }

    @GetMapping("/getProductsByExpirationAfter")
    public List<ReviewResponse> findProductsByExpirationAfter(@RequestBody ProductRequest request){
        return productService.findProductsByExpirationAfter(request);
    }

    @GetMapping("/getProductsExpirationBefore")
    public List<ReviewResponse> findProductsByExpirationBefore(@RequestBody ProductRequest request){
        return productService.findProductsByExpirationBefore(request);
    }

}
