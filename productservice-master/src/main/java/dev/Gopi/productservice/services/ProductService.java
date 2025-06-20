package dev.Gopi.productservice.services;

import dev.Gopi.productservice.dtos.GenericProductDto;
import dev.Gopi.productservice.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {

    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto getProductById(Long id) throws NotFoundException;

    List<GenericProductDto> getAllProducts();

   GenericProductDto deleteProduct(Long id);
}
