package com.example.shopping.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private Long id;
    private String name;
    private String price;
    private Date expirationDate;

}
