package com.giftown.ecommerce.service;

import com.giftown.ecommerce.dto.order.OrderRequest;
import com.giftown.ecommerce.entity.Order;
import com.giftown.ecommerce.entity.OrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface IOrderService {

    Order getOrderById(Long orderId);

    List<OrderItem> getOrderItemsByOrderId(Long orderId);

    Page<Order> getAllOrders(Pageable pageable);

    Page<Order> getUserOrders(String email, Pageable pageable);

    Boolean deleteOrder(Long orderId);

    Order postOrder(OrderRequest validOrder, Map<Long, Long> productId);
}
