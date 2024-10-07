package com.giftown.ecommerce.dto.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductMetaDataResponseModel {
    private Long id;
    private Long productId;
    private double price;
    private String brand;
    private int quantity;
    private String imageUrl;
    private String sku;
    private Double weight;
    private String color;
    private String material;
    private String manufacturer;
    private boolean availability;
    private String description;
    private String addInformation;
    private Boolean isTrending;
}
