package com.giftown.ecommerce.service.Implementation;

import com.giftown.ecommerce.entity.Product;
import com.giftown.ecommerce.entity.ProductSize;
import com.giftown.ecommerce.repository.ProductRepository;
import com.giftown.ecommerce.repository.ProductSizeRepository;
import com.giftown.ecommerce.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final ProductSizeRepository productSizeRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductSizeRepository productSizeRepository) {
        this.productRepository = productRepository;
        this.productSizeRepository = productSizeRepository;
    }

    public Product getProductById(Long productId) {
        return productRepository.findAllById(productId);
    }

    @Override
    public Page<Product> getAllProducts(Pageable pageable){ // Implement this method
        return productRepository.findAllByOrderByIdAsc(pageable);
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

    public List<ProductSize> getAvailableSizes(Long productId, Long subCategoryId) {
        // Check if subcategory-level sizes exist
        List<ProductSize> subCategorySizes = productSizeRepository.findBySubCategoryId(subCategoryId);
        //if (!subCategorySizes.isEmpty())
            return subCategorySizes; // Return sizes at subcategory level if available

    }
}
//        // Otherwise, return sizes at the product level
//        List<ProductSize> productSizes = productRepository.findSizeByProductId(productId);
//        return productSizes; // Fall back to product-level sizes


