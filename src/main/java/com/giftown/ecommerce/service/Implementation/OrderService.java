package com.giftown.ecommerce.service.Implementation;

import com.giftown.ecommerce.dto.order.OrderRequest;
import com.giftown.ecommerce.entity.Order;
import com.giftown.ecommerce.entity.OrderItem;
import com.giftown.ecommerce.entity.Product;
import com.giftown.ecommerce.exception.ApiRequestException;
import com.giftown.ecommerce.repository.OrderItemRepository;
import com.giftown.ecommerce.repository.OrderRepository;
import com.giftown.ecommerce.repository.ProductRepository;
import com.giftown.ecommerce.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static com.giftown.ecommerce.constants.ErrorMessage.ORDER_NOT_FOUND;

@Service
public class OrderService implements IOrderService {


    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public Order getOrderById(Long orderId) {
        logger.info("Fetching order with ID: {}", orderId);
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new ApiRequestException(ORDER_NOT_FOUND, HttpStatus.NOT_FOUND));
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
        logger.info("Fetching order items for order ID: {}", orderId);
        Order order = getOrderById(orderId);
        List<OrderItem> orderItems = order.getOrderItems();
        if (orderItems == null || orderItems.isEmpty()) {
            logger.warn("No items found for order ID: {}", orderId);
        }
        return orderItems;
    }

    @Override
    public Page<Order> getAllOrders(Pageable pageable) {
        logger.info("Fetching all orders with pagination: {}", pageable);
        return orderRepository.findAllByOrderByIdAsc(pageable);
    }

    @Override
    public Page<Order> getUserOrders(String email, Pageable pageable) {
        logger.info("Fetching orders for user with email: {} and pagination: {}", email, pageable);
        return orderRepository.findOrderByEmail(email, pageable);
    }

    @Override
    @Transactional
    public Boolean deleteOrder(Long orderId) {
        logger.info("Attempting to deactivate order with ID: {}", orderId);
        try {
            orderRepository.deactivateOrder(orderId);
            logger.info("Order successfully deactivated with ID: {}", orderId);
        } catch (Exception e) {
            logger.error("Error while deactivating order with ID: {}", orderId, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to deactivate order", e);
        }
        orderRepository.deactivateOrder(orderId);
        return true;
    }


    @Override
    public Order postOrder(OrderRequest orderRequest, Map<Long, Long> productId) {
        List<OrderItem> orderItemList = new ArrayList<>();
        Order order = new Order();
        order.setTotalPrice(orderRequest.getTotalPrice());
        order.setFirstName(orderRequest.getFirstName());
        order.setLastName(orderRequest.getLastName());
        order.setCity(orderRequest.getCity());
        order.setAddress(orderRequest.getAddress());
        order.setEmail(orderRequest.getEmail());
        order.setPhoneNumber(orderRequest.getPhoneNumber());
        order.setPostIndex(orderRequest.getPostIndex());

        for (Map.Entry<Long, Long> entry : productId.entrySet()) {
            Product product = productRepository.findById(entry.getKey()).get();
            if (product != null) {
                OrderItem orderItem = new OrderItem();
                orderItem.setProduct(product);
                orderItem.setAmount((product.getMetadata().getPrice() * entry.getValue()));
                orderItem.setQuantity(entry.getValue());
               orderItem.setOrder(order);
                orderItemList.add(orderItem);
                // orderItemRepository.save(orderItem);
            }
            else {
                logger.warn("Product not found for ID: {}", entry.getKey());
            }
        }
        try {
            Order savedOrder = orderRepository.save(order);
            logger.info("Order created successfully with ID: {}", savedOrder.getId());
            return savedOrder;
        } catch (Exception e) {
            logger.error("Error while creating order", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to create order", e);
        }

    }
}
