package com.giftown.ecommerce.service.Implementation;

import com.giftown.ecommerce.entity.Product;
import com.giftown.ecommerce.repository.ProductRepository;
import com.giftown.ecommerce.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
