package com.veyselozturk.productuserreviewapp.repository;


import com.veyselozturk.productuserreviewapp.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findReviewsByReviewDateBetweenAndProductId
            (Date minDate, Date maxDate, Long productId);

    List<Review> findReviewsByReviewDateBetweenAndUserId
            (Date minDate, Date maxDate, Long userId);

    List<Review> findReviewsByProductId (Long productId);

    List<Review> findReviewsByUserId (Long productId);

}
