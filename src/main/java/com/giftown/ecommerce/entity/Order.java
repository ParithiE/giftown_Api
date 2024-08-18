package com.giftown.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_seq")
    @SequenceGenerator(name = "orders_seq", sequenceName = "orders_seq", initialValue = 6, allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "post_index")
    private Integer postIndex;

    @Column(name = "isActive")
    private Boolean IsActive = true;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;

    public Order() {
        this.date = LocalDate.now();
        this.orderItems = new ArrayList<>();
    }
}
