package dev.Gopi.productservice.services;

import dev.Gopi.productservice.dtos.GenericProductDto;
import dev.Gopi.productservice.exceptions.NotFoundException;
import dev.Gopi.productservice.thirdpartyclients.productsservice.fakestore.FakeStoreProductDto;
import dev.Gopi.productservice.thirdpartyclients.productsservice.fakestore.FakeStoryProductServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


//@Primary
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private FakeStoryProductServiceClient fakeStoryProductServiceClient;


    @Autowired
    public FakeStoreProductService(FakeStoryProductServiceClient fakeStoryProductServiceClient) {
        this.fakeStoryProductServiceClient = fakeStoryProductServiceClient;
    }

    private GenericProductDto convertFakeStoreProductIntoGenericProduct(FakeStoreProductDto fakeStoreProductDto) {

        GenericProductDto product = new GenericProductDto();
        product.setId(fakeStoreProductDto.getId());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());

        return product;
    }

//    public FakeStoreProductService(FakeStoryProductServiceClient fakeStoryProductServiceClient) {
//        this.fakeStoryProductServiceClient = fakeStoryProductServiceClient;
//    }


    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return convertFakeStoreProductIntoGenericProduct(fakeStoryProductServiceClient.createProduct(product));
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        System.out.println("In product service");
        return convertFakeStoreProductIntoGenericProduct(fakeStoryProductServiceClient.getProductById(id));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<GenericProductDto> genericProductDtos = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProductDto: fakeStoryProductServiceClient.getAllProducts()) {
            genericProductDtos.add(convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto));
        }
        return genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        return convertFakeStoreProductIntoGenericProduct(fakeStoryProductServiceClient.deleteProduct(id));
    }
}
