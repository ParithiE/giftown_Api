package com.giftown.ecommerce.dto.order;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Setter
@Getter
@ToString
public class OrderRequest {

    private Double totalPrice;

    private Map<Long, Long> productId;

    private String firstName;

    private String lastName;

    private String city;

    private String address;

    private String email;

    private String phoneNumber;

    private Integer postIndex;

}
