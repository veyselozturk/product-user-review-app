package com.example.shopping.dto.request;

import com.example.shopping.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
}
