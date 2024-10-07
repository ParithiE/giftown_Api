package com.giftown.ecommerce.repository;


import com.giftown.ecommerce.entity.Order;
import com.giftown.ecommerce.entity.Product;
import com.giftown.ecommerce.entity.ProductSize;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByOrderByIdAsc(Pageable pageable);

    Product findAllById(Long productId);
    // Search by keywords in name, description, and category
    @Query("SELECT p FROM Product p " +
            "JOIN p.category c " +
            "LEFT JOIN p.metadata m " +
            "WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(c.categoryname) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(m.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(m.sku) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(m.color) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(m.material) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(m.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(m.manufacturer) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Product> searchProducts(@Param("keyword") String keyword);
    // Find products by category
    @Query("SELECT p FROM Product p join p.category c WHERE c.categoryname = :category")
    List<Product> findByCategory(String category);

    // Find products by brand
    @Query("SELECT p FROM Product p join p.metadata m WHERE m.brand = :brand")
    List<Product> findByBrand(String brand);

    // Find products by price range
    @Query("SELECT p FROM Product p join p.metadata m WHERE m.price BETWEEN :minPrice AND :maxPrice")
    List<Product> findByPriceBetween(@Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice);

    // Find products by multiple criteria
    @Query("SELECT p FROM Product p join p.category c left join p.metadata m WHERE c.categoryname = :category AND m.brand = :brand AND m.price BETWEEN :minPrice AND :maxPrice")
    List<Product> findByCriteria(
            @Param("category") String category,
            @Param("brand") String brand,
            @Param("minPrice") double minPrice,
            @Param("maxPrice") double maxPrice
    );

}

