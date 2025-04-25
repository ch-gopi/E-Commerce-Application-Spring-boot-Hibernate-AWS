package com.scaler.productservice.service;

import com.scaler.productservice.dtos.FakestoreProductDto;
import com.scaler.productservice.exceptions.ProductNotExistsException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;
import java.util.*;
import java.util.stream.Collectors;



@Service
public class FakestoreProductService implements ProductService {

    private final RestTemplate restTemplate;
    List<Product> products = new ArrayList<>();

    @Autowired
    public FakestoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    // This method is for converting FakestoreProduct to our product(considered in the project).
    private Product convertProductDtoToProduct(FakestoreProductDto fakestoreProduct) {
        if (fakestoreProduct == null) {
            // Handle the case where fakestoreProduct is null
            throw new IllegalArgumentException("fakestoreProduct cannot be null");
        }
        //Creating a new Product object.
        Product product = new Product();
        //Assigning a new Category object to this product.
        product.setCategory(new Category(fakestoreProduct.getTitle()));
        // Setting the category name for this product to match the category name from fakestoreProduct
        product.getCategory().setName(fakestoreProduct.getCategory());
        product.setId(fakestoreProduct.getId());
        product.setTitle(fakestoreProduct.getTitle());
        product.setImageUrl(fakestoreProduct.getUrl());
        product.setPrice(fakestoreProduct.getPrice());
        product.setDescription(fakestoreProduct.getDescription());
        return product;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistsException{
    //   int a = 1/0;
        FakestoreProductDto productDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakestoreProductDto.class);
        if(productDto == null){
            throw new ProductNotExistsException("Product with id "+ id+" doesn't exists");
            }
        return convertProductDtoToProduct(productDto);
    }
    // here FakestoreProductDto.class is converting the response we're getting from the URL to its object type.
    @Override
    public List<Product> getAllProducts() {
        // below line gives error because The List generic type shouldn't be used directly like this in a method
        // call. You need to specify the actual class type for the response, and unfortunately, Java doesn't support
        // generic type information at runtime.

       // List<FakestoreProductDto> response = restTemplate.getForObject("https://fakestoreapi.com/products",List.class>);

      //  List<FakestoreProductDto> response = restTemplate.getForObject("https://fakestoreapi.com/products",List.class);
      FakestoreProductDto [] response = restTemplate.getForObject("https://fakestoreapi.com/products",FakestoreProductDto[].class);
        List<Product> answer = new ArrayList<>();
        assert response != null;
        for(FakestoreProductDto dto : response){
            answer.add(convertProductDtoToProduct(dto));
        }
        return answer;
        // we can also solve above issue by using ParameterizedTypeReference
    }

    @Override
    public void addNewProduct(Product product) {
        products.add(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        FakestoreProductDto fakestoreProductDto = new FakestoreProductDto();
        // Create request entity with the updated product details
        HttpEntity<FakestoreProductDto> requestEntity = new HttpEntity<>(fakestoreProductDto);

        // Execute the PUT request
        ResponseEntity<FakestoreProductDto> responseEntity = restTemplate.exchange(
                "https://fakestoreapi.com/products/" + id,
                HttpMethod.PUT,
                requestEntity,
                FakestoreProductDto.class
        );

        // Convert the response DTO to Product
        FakestoreProductDto response = responseEntity.getBody();
        return convertProductDtoToProduct(response);
    }
    @Override
    public void deleteProduct(Long id) {
    for(int i = 0; i<products.size();i++){
        if(Objects.equals(id, products.get(i).getId())){
            products.remove(i);
            break;
        }
    }
  }

  @Override
  public Product replaceProduct(Long id, Product product){
        FakestoreProductDto productDto = new FakestoreProductDto();
        productDto.setTitle(product.getTitle());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        productDto.setUrl(product.getImageUrl());
        productDto.setCategory(product.getCategory().getName());
      RequestCallback requestCallback = restTemplate.httpEntityCallback(productDto, FakestoreProductDto.class);
      HttpMessageConverterExtractor<FakestoreProductDto> responseExtractor =
              new HttpMessageConverterExtractor<>(FakestoreProductDto.class, restTemplate.getMessageConverters());
      FakestoreProductDto response = restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback,responseExtractor);
      return convertProductDtoToProduct(response);
  }
  @Override
    public List<Category> getAllCategories(){
        String [] categoryNames = restTemplate.getForObject("https://fakestoreapi.com/products/categories",String [].class);
      List<Category> categories = Arrays.stream(categoryNames)
              .map(Category::new)
              .collect(Collectors.toList());
      return categories;
    }

    @Override
    public List<Product> getProductWithCategory(String name){
        Product [] products1 = restTemplate.getForObject("https://fakestoreapi.com/products/category/" + name,Product [].class);
        return Arrays.asList(products1);
    }
}
