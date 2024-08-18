package com.giftown.ecommerce.controller;

import com.giftown.ecommerce.dto.order.OrderItemResponseModel;
import com.giftown.ecommerce.dto.order.OrderRequest;
import com.giftown.ecommerce.dto.order.OrderResponseModel;
import com.giftown.ecommerce.exception.ApiRequestException;
import com.giftown.ecommerce.mapper.OrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.giftown.ecommerce.constants.PathConstants.*;


@RestController
@RequestMapping(ORDER)
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderMapper orderMapper;

    @GetMapping(ORDER_ID)
    public ResponseEntity<OrderResponseModel> getOrderById(@PathVariable Long orderId) {

        logger.info("Fetching order with ID: {}", orderId);
        OrderResponseModel orderResponseModel = orderMapper.getOrderById(orderId);
        if (orderResponseModel == null) {
            logger.warn("Order not found for ID: {}", orderId);
            throw new ApiRequestException("Order not found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(orderResponseModel);
    }

    @GetMapping(ORDER_ID_ITEMS)
    public ResponseEntity<List<OrderItemResponseModel>> getOrderItemsByOrderId(@PathVariable Long orderId) {

        logger.info("Fetching order items for order ID: {}", orderId);
        List<OrderItemResponseModel> items = orderMapper.getOrderItemsByOrderId(orderId);
        if (items.isEmpty()) {
            logger.warn("No items found for order ID: {}", orderId);
            throw new ApiRequestException("No items found for order ID " + orderId, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(items);
    }

//    @GetMapping
//    public ResponseEntity<List<OrderResponseModel>> getUserOrders(
//                                                             @PageableDefault(size = 10) Pageable pageable) {
//        HeaderResponse<OrderResponseModel> response = orderMapper.getUserOrders(user.getEmail(), pageable);
//        return ResponseEntity.ok().headers(response.getHeaders()).body(response.getItems());
//    }


    @PutMapping("/delete/{orderId}")
    public ResponseEntity<Boolean> deactivateOrder(@PathVariable Long orderId) {
        logger.info("Deactivating order with ID: {}", orderId);
        boolean result = orderMapper.deleteOrder(orderId);
        if (!result) {
            logger.warn("Order not found or could not be deactivated for ID: {}", orderId);
            throw new ApiRequestException("Order not found or could not be deactivated", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }


    @PostMapping(path="/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderResponseModel> postOrder(@Valid @RequestBody OrderRequest order, BindingResult bindingResult) {
        logger.info("Creating new order with request: {}", order);
        if (bindingResult.hasErrors()) {
            logger.warn("Validation errors occurred while creating order: {}", bindingResult.getAllErrors());
            throw new ApiRequestException("Validation errors occurred while creating order", HttpStatus.BAD_REQUEST);
        }
        OrderResponseModel orderResponseModel = orderMapper.postOrder(order, bindingResult);
        return ResponseEntity.ok(orderResponseModel);
    }
}
