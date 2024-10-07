package com.giftown.ecommerce.controller;

import com.giftown.ecommerce.dto.HeaderResponse;
import com.giftown.ecommerce.dto.product.ProductResponseModel;
import com.giftown.ecommerce.dto.product.ProductSizeResponseModel;
import com.giftown.ecommerce.entity.Product;
import com.giftown.ecommerce.entity.ProductSize;
import com.giftown.ecommerce.mapper.ProductMapper;
import com.giftown.ecommerce.service.Implementation.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseModel> getProductById(@PathVariable Long id){
        ProductResponseModel response = productMapper.getProductById(id);
       return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseModel>> getAllProducts(Pageable pageable) {
//        List<Product> products = productService.getAllProducts();
//        List<ProductResponseModel> response = productMapper.getAllProducts(products);
//        return ResponseEntity.ok(response);

        HeaderResponse<ProductResponseModel> response = productMapper.getAllProducts(pageable);
       return ResponseEntity.ok().headers(response.getHeaders()).body(response.getItems());


    }

//    @GetMapping("/search")
//    public ResponseEntity<List<ProductResponseModel>> searchProducts(@RequestParam String keyword) {
//
//        List<Product> products = productService.searchProducts(keyword);
//        List<ProductResponseModel> response = productMapper.getAllProducts();
//        return ResponseEntity.ok(response);
//    }

//    @GetMapping("/category")
//    public ResponseEntity<List<ProductResponseModel>> getProductsByCategory(@RequestParam String category) {
//        List<Product> products = productService.getProductsByCategory(category);
//        List<ProductResponseModel> response = productMapper.getAllProducts(products);
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping("/brand")
//    public ResponseEntity<List<ProductResponseModel>> getProductsByBrand(@RequestParam String brand) {
//        List<Product> products = productService.getProductsByBrand(brand);
//        List<ProductResponseModel> response = productMapper.getAllProducts(products);
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping("/price")
//    public ResponseEntity<List<ProductResponseModel>> getProductsByPriceRange(
//            @RequestParam double minPrice,
//            @RequestParam double maxPrice) {
//        List<Product> products = productService.getProductsByPriceRange(minPrice, maxPrice);
//        List<ProductResponseModel> response = productMapper.getAllProducts(products);
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping("/filter")
//    public ResponseEntity<List<ProductResponseModel>> getProductsByCriteria(
//            @RequestParam(required = false) String category,
//            @RequestParam(required = false) String brand,
//            @RequestParam(required = false, defaultValue = "0") double minPrice,
//            @RequestParam(required = false, defaultValue = "10000") double maxPrice) {
//        List<Product> products = productService.getProductsByCriteria(category, brand, minPrice, maxPrice);
//        List<ProductResponseModel> response = productMapper.getAllProducts(products);
//        return ResponseEntity.ok(response);
//    }
    @GetMapping("/{productId}/{subCategoryId}/sizes")
    public ResponseEntity<List<ProductSizeResponseModel>> getProductSizes(@PathVariable Long productId, @PathVariable Long subCategoryId) {
        List<ProductSizeResponseModel> availableSizes = productMapper.getAvailableSizes(productId, subCategoryId);
        return ResponseEntity.ok(availableSizes);
    }

}