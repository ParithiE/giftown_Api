package com.giftown.ecommerce.mapper;

import com.giftown.ecommerce.dto.HeaderResponse;
import com.giftown.ecommerce.dto.order.OrderItemResponseModel;
import com.giftown.ecommerce.dto.order.OrderRequest;
import com.giftown.ecommerce.dto.order.OrderResponseModel;
import com.giftown.ecommerce.dto.product.ProductResponseModel;
import com.giftown.ecommerce.entity.Order;
import com.giftown.ecommerce.entity.Product;
import com.giftown.ecommerce.service.IOrderService;
import com.giftown.ecommerce.service.Implementation.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.List;

@Component
public class OrderMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CommonMapper commonMapper;

    @Autowired
    private IOrderService orderService;

    public OrderResponseModel getOrderById(Long orderId) {
        return commonMapper.convertToEntity(orderService.getOrderById(orderId), OrderResponseModel.class);
    }

    public List<OrderItemResponseModel> getOrderItemsByOrderId(Long orderId) {
        return commonMapper.convertToResponseList(orderService.getOrderItemsByOrderId(orderId), OrderItemResponseModel.class);
    }

    public HeaderResponse<OrderResponseModel> getAllOrders(Pageable pageable) {
        Page<Order> orders = orderService.getAllOrders(pageable);
        return commonMapper.getHeaderResponse(orders.getContent(), orders.getTotalPages(), orders.getTotalElements(), OrderResponseModel.class);
    }

    public HeaderResponse<OrderResponseModel> getUserOrders(String email, Pageable pageable) {
        Page<Order> orders = orderService.getUserOrders(email, pageable);
        return commonMapper.getHeaderResponse(orders.getContent(), orders.getTotalPages(), orders.getTotalElements(), OrderResponseModel.class);
    }

    public Boolean deleteOrder(Long orderId) {
        return orderService.deleteOrder(orderId);
    }


    public OrderResponseModel postOrder(OrderRequest orderRequest, BindingResult bindingResult) {
        return commonMapper.convertToEntity(orderService.postOrder(orderRequest, orderRequest.getProductId()), OrderResponseModel.class);
    }

//    private OrderResponseModel convertToModel(Order order) {
//        if (order == null) {
//            throw new IllegalArgumentException("Order cannot be null");
//        }
//        modelMapper.typeMap(Order.class, OrderResponseModel.class).addMappings(mapper -> {
//            mapper.map(Order::getId, OrderResponseModel::setId);
//            mapper.map(Order::getFirstName, OrderResponseModel::setFirstName);
//            mapper.map(Order::getLastName, OrderResponseModel::setLastName);
//            mapper.map(Order::getDate, OrderResponseModel::setDate);
//            mapper.map(Order::getCity, OrderResponseModel::setCity);
//            mapper.map(Order::getEmail, OrderResponseModel::setEmail);
//            mapper.map(Order::getAddress, OrderResponseModel::setAddress);
//            mapper.map(Order::getPostIndex, OrderResponseModel::setPostIndex);
//            mapper.map(Order::getPhoneNumber, OrderResponseModel::setPhoneNumber);
//            mapper.map(Order::getTotalPrice, OrderResponseModel::setTotalPrice);
//
//        });
//        OrderResponseModel responseModel = modelMapper.map(order, OrderResponseModel.class);
//
//        return responseModel; // modelMapper.map(order, OrderResponseModel.class);
//
//    }
}
