package com.watiti.productservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private  String description;

    private boolean isDeleted;

    @OneToMany
    private List<Product> productList;

//	@OneToMany(cascade = {CascadeType.ALL})
//	private List<Category> subCategories;

    @ManyToOne
    @JoinColumn
//    @JoinColumn(name="category_id")
    private Category partentCaregory;


}
