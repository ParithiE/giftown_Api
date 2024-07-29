package com.giftown.ecommerce.service.Implementation;

import com.giftown.ecommerce.entity.Product;
import com.giftown.ecommerce.repository.ProductRepository;
import com.giftown.ecommerce.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(Long productId) {
        return productRepository.findAllById(productId);
    }

    @Override
    public List<Product> getAllProducts() { // Implement this method
        return productRepository.findAll();
    }

    public List<Product> searchProducts(String keyword) {
        return productRepository.searchProducts(keyword);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }

    @Override
    public List<Product> getProductsByPriceRange(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public List<Product> getProductsByCriteria(String category, String brand, double minPrice, double maxPrice) {
        return productRepository.findByCriteria(category, brand, minPrice, maxPrice);
    }
}
