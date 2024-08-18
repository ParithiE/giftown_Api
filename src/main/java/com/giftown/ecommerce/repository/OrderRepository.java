package com.giftown.ecommerce.repository;

import com.giftown.ecommerce.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Page<Order> findAllByOrderByIdAsc(Pageable pageable);

    List<Order> findOrderByEmail(String email);

    Page<Order> findOrderByEmail(String email, Pageable pageable);

    @Modifying
    @Query("UPDATE Order o SET o.IsActive = false WHERE o.id = ?1")
    void deactivateOrder(Long orderId);
}
