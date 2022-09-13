package com.veyselozturk.productuserreviewapp.repository;


import com.veyselozturk.productuserreviewapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsByExpirationDateBefore(LocalDate date);
}
