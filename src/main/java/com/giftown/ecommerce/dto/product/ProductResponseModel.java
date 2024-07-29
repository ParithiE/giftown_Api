package com.giftown.ecommerce.dto.product;

import java.util.List;

public class ProductResponseModel {
//    private Long id;
//    private String name;
//    private String description;
//    private Double price;
//    private String category;


    public ProductResponseModel() {
    }

//    public ProductResponseModel(Long id, String name, String description, Double price, String category) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.price = price;
//        this.category = category;
//    }

    private Long id;
    private String productCode;
    private String name;
    private String category;
    private String brand;
    private String description;
    private double price;
    private int quantity;
    private String imageUrl;
    private String sku;
    private double weight;
    private String color;
    private String material;
    private String manufacturer;
    private boolean availability;
    private List<ProductReviewResponseModel> reviews;
    private List<ProductSizeResponseModel> sizes;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
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
    @Override
    public String toString() {
        return "ProductResponseModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}