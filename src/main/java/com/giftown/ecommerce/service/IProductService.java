package com.giftown.ecommerce.service;
import com.giftown.ecommerce.entity.Order;
import com.giftown.ecommerce.entity.Product;
import com.giftown.ecommerce.entity.ProductSize;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    public Product getProductById(Long productId);
    //List<Product> getAllProducts();
    List<Product> searchProducts(String keyword);
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByPriceRange(double minPrice, double maxPrice);
    List<Product> getProductsByCriteria(String category, String brand, double minPrice, double maxPrice);
    List<ProductSize> getAvailableSizes(Long productId, Long subCategoryId);
    Page<Product> getAllProducts(Pageable pageable);
}
