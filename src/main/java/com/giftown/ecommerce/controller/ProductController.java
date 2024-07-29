package com.giftown.ecommerce.controller;

import com.giftown.ecommerce.dto.product.ProductResponseModel;
import com.giftown.ecommerce.entity.Product;
import com.giftown.ecommerce.mapper.ProductMapper;
import com.giftown.ecommerce.service.Implementation.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseModel> getProductById(@PathVariable Long id){
        ProductResponseModel response =productMapper.getProductById(id);
       return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseModel>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductResponseModel> response = productMapper.getAllProducts(products);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductResponseModel>> searchProducts(@RequestParam String keyword) {
        List<Product> products = productService.searchProducts(keyword);
        List<ProductResponseModel> response = productMapper.getAllProducts(products);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/category")
    public ResponseEntity<List<ProductResponseModel>> getProductsByCategory(@RequestParam String category) {
        List<Product> products = productService.getProductsByCategory(category);
        List<ProductResponseModel> response = productMapper.getAllProducts(products);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/brand")
    public ResponseEntity<List<ProductResponseModel>> getProductsByBrand(@RequestParam String brand) {
        List<Product> products = productService.getProductsByBrand(brand);
        List<ProductResponseModel> response = productMapper.getAllProducts(products);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/price")
    public ResponseEntity<List<ProductResponseModel>> getProductsByPriceRange(
            @RequestParam double minPrice,
            @RequestParam double maxPrice) {
        List<Product> products = productService.getProductsByPriceRange(minPrice, maxPrice);
        List<ProductResponseModel> response = productMapper.getAllProducts(products);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ProductResponseModel>> getProductsByCriteria(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false, defaultValue = "0") double minPrice,
            @RequestParam(required = false, defaultValue = "10000") double maxPrice) {
        List<Product> products = productService.getProductsByCriteria(category, brand, minPrice, maxPrice);
        List<ProductResponseModel> response = productMapper.getAllProducts(products);
        return ResponseEntity.ok(response);
    }
}
