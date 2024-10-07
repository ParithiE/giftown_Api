package com.giftown.ecommerce.repository;


import com.giftown.ecommerce.entity.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSizeRepository extends JpaRepository<ProductSize, Long> {

//    @Query("SELECT ps FROM ProductSize ps JOIN ps.size s WHERE ps.subCategory.id = :id")
    List<ProductSize> findBySubCategoryId(Long id);
}