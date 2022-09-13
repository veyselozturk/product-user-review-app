package com.example.shopping.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //string olması hem ilişkisel hem nonilişkisel
    @Size(max=500)
    private String review;
    private Date reviewDate;

    @ManyToOne
    private Product product;
    @ManyToOne
    private User user;
}
