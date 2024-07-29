package com.giftown.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "productmetadata")
public class ProductMetaData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "metadata_id_seq")
    @SequenceGenerator(name = "metadata_id_seq", sequenceName = "metadata_id_seq", initialValue = 1001, allocationSize = 1)
    @Column(name = "metadata_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "price")
    private double price;

    @Column(name = "brand")
    private String brand;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "sku")
    private String sku; // Stock Keeping Unit

    @Column(name = "weight")
    private double weight; // Product weight

    @Column(name = "color")
    private String color;

    @Column(name = "material")
    private String material;

    @Column(name = "manufacturer")
    private String manufacturer; // Manufacturer details

    @Column(name = "availability")
    private boolean availability; // Availability status

    @Column(name = "description", length = 1000) // Adjust length as needed
    private String description;

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private String createdBy;
}
