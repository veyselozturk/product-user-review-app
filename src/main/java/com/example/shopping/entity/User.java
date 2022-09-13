package com.example.shopping.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max=50)
    private String name;
    @Size(max=50)
    private String surname;
    @Size(max=50)
    private String email;
    @Size(max=15)
    private String phone;

    @OneToMany
    @JoinTable(name = "REVIEW_ID")
    private List<Review> Review;

}
