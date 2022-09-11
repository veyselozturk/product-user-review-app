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

    @Size(max=500)
    private String review;

    private Date reviewDate;

    @ManyToOne
    @JoinColumn
    private Product productId;

    @ManyToOne
    @JoinColumn
    private User userId;
}
