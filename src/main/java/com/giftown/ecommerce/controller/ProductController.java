package com.giftown.ecommerce.controller;

import com.giftown.ecommerce.dto.product.ProductResponse;
import com.giftown.ecommerce.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductMapper productMapper;

    public ProductController(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

//    @GetMapping
//    public ResponseEntity<ProductResponse> getAllProducts(@PageableDefault(size = 15) Pageable pageable){
//        productMapper.get(pageable);
//
//    }

    @GetMapping("/{perfumeId}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long productId){
       return ResponseEntity.ok(productMapper.getProductById(productId));
    }

}
