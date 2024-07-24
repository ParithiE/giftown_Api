package com.giftown.ecommerce.controller;

import com.giftown.ecommerce.dto.product.ProductResponseModel;
import com.giftown.ecommerce.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseModel> getProductById(@PathVariable Long id){
        ProductResponseModel response =productMapper.getProductById(id);
       return ResponseEntity.ok(response);
    }

}
