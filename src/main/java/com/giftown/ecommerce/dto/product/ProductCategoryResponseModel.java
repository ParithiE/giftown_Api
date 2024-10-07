package com.giftown.ecommerce.dto.product;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductCategoryResponseModel {

    private Long id;

    private String categoryname;

    private String imageUrl;
}
