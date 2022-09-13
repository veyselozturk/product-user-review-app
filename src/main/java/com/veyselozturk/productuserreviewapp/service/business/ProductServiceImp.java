package com.veyselozturk.productuserreviewapp.service.business;

import com.veyselozturk.productuserreviewapp.dto.request.UserRequest;
import com.veyselozturk.productuserreviewapp.dto.response.ProductResponse;
import com.veyselozturk.productuserreviewapp.dto.response.ReviewResponse;
import com.veyselozturk.productuserreviewapp.dto.response.UserResponse;
import com.veyselozturk.productuserreviewapp.entity.Product;
import com.veyselozturk.productuserreviewapp.entity.Review;
import com.veyselozturk.productuserreviewapp.entity.User;
import com.veyselozturk.productuserreviewapp.repository.ProductRepository;
import com.veyselozturk.productuserreviewapp.repository.ReviewRepository;
import com.veyselozturk.productuserreviewapp.repository.UserRepository;
import com.veyselozturk.productuserreviewapp.service.ProductService;
import com.veyselozturk.productuserreviewapp.dto.request.ProductRequest;
import com.veyselozturk.productuserreviewapp.dto.request.ReviewRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductServiceImp implements ProductService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;


    public ProductServiceImp(ModelMapper modelMapper, UserRepository userRepository, ProductRepository productRepository, ReviewRepository reviewRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    @Transactional
    public Optional<UserResponse> createUser(UserRequest request) {
        var user = modelMapper.map(request, User.class);
        return Optional.of(modelMapper.map(userRepository.save(user), UserResponse.class));
    }
    @Override
    @Transactional
    public Optional<ReviewResponse> createReview(ReviewRequest request) {
        var review = modelMapper.map(request, Review.class);
        return Optional.of(modelMapper.map(reviewRepository.save(review), ReviewResponse.class));
    }
    @Override
    @Transactional
    public Optional<ProductResponse> createProduct(ProductRequest request) {
        var product = modelMapper.map(request, Product.class);
        return Optional.of(modelMapper.map(productRepository.save(product), ProductResponse.class));
    }
    @Override
    public List<ReviewResponse> findReviewsByProductID(Long productId) {
        var list = reviewRepository.findReviewsByProductId(productId)
                .stream().map(review -> modelMapper.map(review,ReviewResponse.class))
                .toList();
        if (list.isEmpty()){
            throw new RuntimeException("Review not found.");
        }
        return list;
    }
    @Override
    public List<ReviewResponse> findReviewsByDateRangeAndProductID(ReviewRequest request) {
        var list = reviewRepository.findReviewsByReviewDateBetweenAndProductId(
                request.getDateRange().get(0),request.getDateRange().get(0),request.getProductId())
                .stream().map(review -> modelMapper.map(review,ReviewResponse.class))
                .toList();
        if (list.isEmpty()){
            throw new RuntimeException("Review not found.");
        }
        return list;
    }
    @Override
    public List<ReviewResponse> findReviewsByUserID(Long userId) {
        var list = reviewRepository.findReviewsByUserId(userId)
                .stream().map(review -> modelMapper.map(review,ReviewResponse.class))
                .sorted(Comparator.comparing(ReviewResponse::getUser_id))
                .toList();
        if (list.isEmpty()){
            throw new RuntimeException("Review not found.");
        }
        return list;
    }
    @Override
    public List<ReviewResponse> findReviewsByDateRangeAndUserID(ReviewRequest request) {
        var list = reviewRepository.findReviewsByReviewDateBetweenAndUserId(
                request.getDateRange().get(0),request.getDateRange().get(0),request.getUserId())
                .stream().map(review -> modelMapper.map(review,ReviewResponse.class))
                .sorted(Comparator.comparing(ReviewResponse::getUser_id))
                .toList();
        if (list.isEmpty()){
            throw new RuntimeException("Review not found.");
        }
        return list;
    }
    @Override
    public List<ProductResponse> findProductsByExpirationBefore(ProductRequest request) { //BAD PRODUCT
        LocalDate localDate = LocalDate.now();
        var list = productRepository.findProductsByExpirationDateBefore(localDate)
                .stream().map(product -> modelMapper.map(product,ProductResponse.class))
                .sorted(Comparator.comparing(ProductResponse::getExpirationDate))
                .toList();
        if (list.isEmpty()){
            throw new RuntimeException("Product not found.");
        }
        return list;
    }
    @Override
    public List<ProductResponse> findProductsByExpirationAfter(ProductRequest request) {
        Date localDate = new Date();
        var list = productRepository.findAll();
        var expirationAfterList= list.stream()
                                                .filter(product -> product.getExpirationDate().after(localDate))
                                                .toList();
        var nullControlList= list.stream()
                                            .filter(product -> product.getExpirationDate().equals(null))
                                            .toList();
        var productsList =
                Stream.concat(expirationAfterList.stream(), nullControlList.stream())
                .map(product -> modelMapper.map(product,ProductResponse.class))
                .collect(Collectors.toList());
        return productsList;
    }

}
