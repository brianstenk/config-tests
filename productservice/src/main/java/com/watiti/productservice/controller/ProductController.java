package com.watiti.productservice.controller;

import com.watiti.productservice.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/api/test")
    public Product testController(){
        return new Product();
    }
}
