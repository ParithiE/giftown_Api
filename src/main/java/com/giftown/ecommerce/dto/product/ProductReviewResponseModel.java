package com.giftown.ecommerce.dto.product;

public class ProductReviewResponseModel {


    private Long id;
    private String author;
    private String message;
    private Integer rating;

    // Default constructor
    public ProductReviewResponseModel() {
    }

    // Parameterized constructor
    public ProductReviewResponseModel(Long id, String author, String message, Integer rating) {
        this.id = id;
        this.author = author;
        this.message = message;
        this.rating = rating;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "ProductReviewResponseModel{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", message='" + message + '\'' +
                ", rating=" + rating +
                '}';
    }
}
