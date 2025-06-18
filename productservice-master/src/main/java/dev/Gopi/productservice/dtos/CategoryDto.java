package dev.naman.productservice.dtos;

import dev.naman.productservice.security.JwtObject;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDto {
    private String name;

    private List<ProductDto> products;

}
