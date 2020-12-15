package com.watiti.productservice.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String title;
    private String description;
    private double price;
    private LocalDate creationDate;
    private String attributes;
    private long vendorId;
    private String imageUrl;
    private long stockAmount;
    //for Order
    private long soldAmount;
    private boolean isPublished = false;
    private boolean isDeleted= false;
    @ManyToMany
    @JoinTable
    private List<Promotion> promotions;

}
