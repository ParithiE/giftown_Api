package com.giftown.ecommerce.service;
import com.giftown.ecommerce.entity.Product;

public interface IProductService {

    public Product getProductById(Long productId);
}
