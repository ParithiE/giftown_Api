package com.giftown.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@Table(name = "product_fields")
public class ProductFields {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "field_id_seq")
    @SequenceGenerator(name = "field_id_seq", sequenceName = "field_id_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "field_name", nullable = false)
    private String fieldName;

    @Column(name = "field_type", nullable = false)
    private String fieldType;

    @Column(name = "is_required", nullable = false)
    private boolean isRequired;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = true)  // Adding reference to Product
    private Product product;

    // Additional properties if needed
}