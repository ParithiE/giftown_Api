package com.giftown.ecommerce.repository;


import com.giftown.ecommerce.domain.Product;
import com.giftown.ecommerce.repository.projection.ProductProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<ProductProjection> findAllByOrderByIdAsc();

    @Query("SELECT product FROM Product product ORDER BY product.id ASC")
    Page<ProductProjection> findAllByOrderByIdAsc(Pageable pageable);

    List<Product> findByCategoryOrderByPriceDesc(String category);

    List<Product> findAllById(Long productIds);

    @Query("SELECT product FROM Product product WHERE product.id IN :productIds")
    List<ProductProjection> getProductsByIds(List<Long> productIds);
//
//    @Query("SELECT product FROM Product product " +
//            "WHERE (coalesce(:categories, null) IS NULL OR product.category IN :categories) " +
//            "AND (coalesce(:priceStart, null) IS NULL OR product.price BETWEEN :priceStart AND :priceEnd) " +
//            "ORDER BY CASE WHEN :sortByPrice = true THEN product.price ELSE -product.price END ASC")
//    Page<ProductProjection> findProductsByFilterParams(
//            List<String> categories,
//            List<String> genders,
//            Integer priceStart,
//            Integer priceEnd,
//            boolean sortByPrice,
//            Pageable pageable);
//
//    @Query("SELECT product FROM Product product " +
//            "WHERE UPPER(product.manufacturer) LIKE UPPER(CONCAT('%',:text,'%')) " +
//            "ORDER BY product.price DESC")
//    Page<ProductProjection> findByManufacturer(String text, Pageable pageable);
//
//    @Query("SELECT product FROM Product product " +
//            "WHERE UPPER(product.name) LIKE UPPER(CONCAT('%',:text,'%')) " +
//            "ORDER BY product.price DESC")
//    Page<ProductProjection> findByProductName(String text, Pageable pageable);
//
//    @Query("SELECT product FROM Product product " +
//            "WHERE UPPER(product.description) LIKE UPPER(CONCAT('%',:text,'%')) " +
//            "ORDER BY product.price DESC")
//    Page<ProductProjection> findByProductDescription(String text, Pageable pageable);
}

