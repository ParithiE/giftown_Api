package com.giftown.ecommerce.service.Implementation;

import com.giftown.ecommerce.domain.Product;
import com.giftown.ecommerce.exception.ApiRequestException;
import com.giftown.ecommerce.repository.ProductRepository;
import com.giftown.ecommerce.repository.projection.ProductProjection;
import com.giftown.ecommerce.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
        return productRepository.findById(productId)
                .orElseThrow(() -> new ApiRequestException("Product not found", HttpStatus.NOT_FOUND));
    }

    public Page<ProductProjection> getAllProducts(Pageable pageable) {
        return productRepository.findAllByOrderByIdAsc(pageable);
    }

    public List<ProductProjection> getProductsByIds(List<Long> productIds) {
        return productRepository.getProductsByIds(productIds);
    }
//
//    public Page<ProductProjection> findProductsByFilterParams(ProductSearchRequest filter, Pageable pageable) {
//        return productRepository.findProductsByFilterParams(
//                filter.getCategories(),
//                filter.getGenders(),
//                filter.getPriceStart(),
//                filter.getPriceEnd(),
//                filter.isSortByPrice(),
//                pageable);
//    }

    public List<Product> findByCategory(String category) {
        return productRepository.findByCategoryOrderByPriceDesc(category);
    }
//
//    public Page<ProductProjection> findByProductDescription(String description,  Pageable pageable) {
//        return productRepository.findByProductDescription(description, pageable);
//    }
//
//    public Page<ProductProjection> findByName(String text, Pageable pageable) {
//        return productRepository.findByProductName(text, pageable);
//    }

    // Implement save, delete, and other methods as per your application needs
}
