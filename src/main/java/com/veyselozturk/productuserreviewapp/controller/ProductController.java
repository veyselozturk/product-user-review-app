package com.veyselozturk.productuserreviewapp.controller;

import com.veyselozturk.productuserreviewapp.dto.request.ProductRequest;
import com.veyselozturk.productuserreviewapp.dto.request.ReviewRequest;
import com.veyselozturk.productuserreviewapp.dto.request.UserRequest;
import com.veyselozturk.productuserreviewapp.dto.response.ProductResponse;
import com.veyselozturk.productuserreviewapp.dto.response.ReviewResponse;
import com.veyselozturk.productuserreviewapp.dto.response.UserResponse;
import com.veyselozturk.productuserreviewapp.service.ProductService;
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
    public List<ReviewResponse> findReviewsByProductID(@RequestParam ReviewRequest request){
        return productService.findReviewsByProductID(request.getProductId());
    }

    @GetMapping("/getReviewsByDateRangeAndProductID")
    public List<ReviewResponse> findReviewsByDateRangeAndProductID(@RequestBody ReviewRequest request){
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
    public List<ProductResponse> findProductsByExpirationAfter(@RequestBody ProductRequest request){
        return productService.findProductsByExpirationAfter(request);
    }

    @GetMapping("/getProductsExpirationBefore")
    public List<ProductResponse> findProductsByExpirationBefore(@RequestBody ProductRequest request){
        return productService.findProductsByExpirationBefore(request);
    }

}
