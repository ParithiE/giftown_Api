package com.giftown.ecommerce.dto.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderItemResponseModel {

    private Long id;
    private Long orderId;
    private Long productId;
    private Double amount;
    private Long quantity;

    public OrderItemResponseModel() {
    }

    public OrderItemResponseModel(Long id, Long orderId, Long productId, Double amount, Long quantity) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.amount = amount;
        this.quantity = quantity;
    }
}
