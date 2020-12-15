package com.watiti.productservice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;



    private  String description;

    private boolean isDeleted;

//	@OneToMany(cascade = {CascadeType.ALL})
//	private List<Category> subCategories;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category partentCaregory;


}
