package com.giftown.ecommerce.dto.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductSubCategoryResponseModel {
    private Long id;

    private String subcategoryName;

    private String imageUrl;
}
