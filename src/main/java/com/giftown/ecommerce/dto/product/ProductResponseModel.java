package com.giftown.ecommerce.dto.product;

import lombok.ToString;

import java.util.List;

@ToString
public class ProductResponseModel {
    public ProductResponseModel() {
    }
    private Long id;
    private String productCode;
    private String name;
    private List<ProductReviewResponseModel> reviews;
    private List<ProductSizeResponseModel> sizes;
    private ProductCategoryResponseModel category;
    private ProductSubCategoryResponseModel subCategory;
    private ProductMetaDataResponseModel productMetaData;


    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategoryResponseModel getCategory() {
        return category;
    }

    public void setCategory(ProductCategoryResponseModel category) {
        this.category = category;
    }
    public ProductMetaDataResponseModel getProductMetaData() {
        return productMetaData;
    }

    public void setProductMetaData(ProductMetaDataResponseModel productMetaData) {
        this.productMetaData = productMetaData;
    }

    public ProductSubCategoryResponseModel getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(ProductSubCategoryResponseModel subCategory) {
        this.subCategory = subCategory;
    }

    public List<ProductReviewResponseModel> getReviews() {
        return reviews;
    }

    public void setReviews(List<ProductReviewResponseModel> reviews) {

        this.reviews = reviews;
    }

    public List<ProductSizeResponseModel> getSizes() {
        return sizes;
    }

    public void setSizes(List<ProductSizeResponseModel> sizes) {

        System.out.println("Size" + sizes.toString());
        this.sizes = sizes;
    }
//    @Override
//    public String toString() {
//        return "ProductResponseModel{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                ", price=" + price +
//                ", category='" + category + '\'' +
//                '}';
//    }
}