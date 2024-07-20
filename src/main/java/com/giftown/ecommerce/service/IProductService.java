package com.giftown.ecommerce.service;
import com.giftown.ecommerce.domain.Product;
import com.giftown.ecommerce.repository.projection.ProductProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    public Product getProductById(Long productId);

    public Page<ProductProjection> getAllProducts(Pageable pageable);

    public List<ProductProjection> getProductsByIds(List<Long> productIds);

//  //  public Page<ProductProjection> findProductsByFilterParams(ProductSearchRequest filter, Pageable pageable);
//
//    public List<Product> findByCategory(String category);
//
//    public Page<ProductProjection> findByProductDescription(String description,  Pageable pageable);
//
//    public Page<ProductProjection> findByName(String text, Pageable pageable);
}
