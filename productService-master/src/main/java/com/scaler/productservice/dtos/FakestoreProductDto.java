package com.scaler.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakestoreProductDto {
    private Long id;
    private String title;
    private double price;
    private String Category;
    private String description;
    private String url;
}
