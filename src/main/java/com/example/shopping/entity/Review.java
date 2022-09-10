package com.example.shopping.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //string olması hem ilişkisel hem nonilişkisel

    @Column(length = 500)
    private String review;

    private Date reviewDate;

    private String productId;

    private String userId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product_ID;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_ID;
}
