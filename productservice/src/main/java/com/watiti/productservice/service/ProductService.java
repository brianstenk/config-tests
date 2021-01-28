package com.watiti.productservice.service;

import com.watiti.productservice.exception.NoSuchResourceException;
import com.watiti.productservice.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public Product addProduct(Product product);

    //public Optional<Product> getProduct(long productId) throws NoSuchResourceException;

    Product getProduct(long productId) throws NoSuchResourceException;

    public List<Product> getProducts();

   // public Optional<Product> editProduct(long productID, Product edit_product);

    //public Optional<Product> deleteProduct(long productId) throws NoSuchResourceException;

    Product editProduct(long productID, Product edit_product);

    Product deleteProduct(long productId) throws NoSuchResourceException;

    Product updateStock(long soldAmount, long productId);
    public List<Product> findByTitle(String title);

    public List<Product> findByTitleAndDescription(String title, String description);

    public List<Product> findByCategoryName(String name);

    List<Product> getVendorProducts(long vendorId);

    Product createProductWithImage(MultipartFile image, Product product);

    Product updateProductWithImage(MultipartFile image, Product product);

    List<Product> getVendorPublishedProducts(long vendorId);

    List<Product> getVendorNonPublishedProducts(long vendorId);

    List<Product> getNonDeletedProducts();

    List<Product> getDeletedProducts();

    List<Product> getPublishedProducts();

    List<Product> getNonPublishedProducts();


    List<Product> findAllProductIn(List<Long> ProductIds);

    public List<Product> search(String keyword, Long categoryid, Double minprice, Double maxprice);
}
