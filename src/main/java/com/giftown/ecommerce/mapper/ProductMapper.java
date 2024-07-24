package com.giftown.ecommerce.mapper;

import com.giftown.ecommerce.dto.product.ProductResponseModel;
import com.giftown.ecommerce.entity.Product;
import com.giftown.ecommerce.service.Implementation.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProductMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private  ProductService productService;

    public ProductResponseModel getProductById(Long productId) {
        return this.convertToModel(productService.getProductById(productId));
    }

    private ProductResponseModel convertToModel(Product product) {
        ProductResponseModel response =  new ProductResponseModel();
//        response.setId(product.getId());
//        response.setName(product.getName());
//        response.setDescription(product.getDescription());
//        response.setPrice(product.getPrice());
//        response.setCategory(product.getCategory());

        modelMapper.typeMap(Product.class, ProductResponseModel.class).addMappings(mapper -> {
            mapper.map(Product::getId, ProductResponseModel::setId);
            mapper.map(Product::getName, ProductResponseModel::setName);
            mapper.map(Product::getDescription, ProductResponseModel::setDescription);
            mapper.map(Product::getPrice, ProductResponseModel::setPrice);
            mapper.map(Product::getCategory, ProductResponseModel::setCategory);
        });
        return modelMapper.map(Product.class, ProductResponseModel.class);
    }

}
