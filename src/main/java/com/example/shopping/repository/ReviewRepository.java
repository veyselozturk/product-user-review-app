package com.example.shopping.repository;


import com.example.shopping.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, String> {
    List<Review> findReviewsByReviewDateBetweenAndProduct_ID
            (Date date1, Date date2, Long product_ID);

    List<Review> findReviewsByReviewDateBetweenAndUser_ID
            (Date date1, Date date2, Long user_ID);
}
