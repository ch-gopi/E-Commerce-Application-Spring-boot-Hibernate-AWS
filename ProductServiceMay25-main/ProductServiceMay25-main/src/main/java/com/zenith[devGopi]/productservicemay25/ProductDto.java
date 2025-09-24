package com.zenith.productservicemay25;

import com.zenith.productservicemay25.models.Product;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Product}
 */
@Value
public class ProductDto implements Serializable {
    String title;
    Double price;
    String description;
}