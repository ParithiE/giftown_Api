package com.giftown.ecommerce.service;
import com.giftown.ecommerce.entity.Product;

import java.util.List;

public interface IProductService {

    public Product getProductById(Long productId);
    List<Product> getAllProducts();
    List<Product> searchProducts(String keyword);
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByPriceRange(double minPrice, double maxPrice);
    List<Product> getProductsByCriteria(String category, String brand, double minPrice, double maxPrice);


}
