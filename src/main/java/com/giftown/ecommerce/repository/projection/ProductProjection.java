package com.giftown.ecommerce.repository.projection;

import org.springframework.beans.factory.annotation.Value;

public interface ProductProjection {
    Long getId();
    String getProductTitle();
    String getProduct();
    Integer getPrice();
    String getFilename();
    Double getProductRating();
    
    @Value("#{target.reviews.size()}")
    Integer getReviewsCount();

    void setPerfumer(String perfumer);
    void setPerfumeGender(String perfumeGender);
    void setPrice(Integer price);
}
