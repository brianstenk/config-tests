package com.watiti.productservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
@Entity
@Data
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String  title;
    private LocalDate startDate;
    private LocalDate endDate;
    private double discount;
    private boolean isDeleted;
    private Long vendorId;
}
