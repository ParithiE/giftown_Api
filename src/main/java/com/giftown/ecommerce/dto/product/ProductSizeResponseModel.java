package com.giftown.ecommerce.dto.product;

public class ProductSizeResponseModel {
    private Long id;
    private String size;
    private double additionalPrice;
//    private int quantity;

    // Default constructor
    public ProductSizeResponseModel() {
    }

    // Parameterized constructor
    public ProductSizeResponseModel(Long id, String size, double additionalPrice) {
        this.id = id;
        this.size = size;
        this.additionalPrice = additionalPrice;
//        this.quantity = quantity;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getAdditionalPrice() {
        return additionalPrice;
    }

    public void setAdditionalPrice(double additionalPrice) {
        this.additionalPrice = additionalPrice;
    }

//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }

    @Override
    public String toString() {
        return "ProductSizeResponseModel{" +
                "id=" + id +
                ", size='" + size + '\'' +
                ", additionalPrice=" + additionalPrice +
//                ", quantity=" + quantity +
                '}';
    }
}
