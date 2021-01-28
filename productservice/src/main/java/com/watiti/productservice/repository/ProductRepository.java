package com.watiti.productservice.repository;

import com.watiti.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByTitleAndDescription(String title, String description);
    @Query("SELECT d from Product d where d.vendorId= :id order by d.id")
    List<Product> findRProductsByVendorId(@Param("id") Long id);

    @Query("SELECT p FROM Product p WHERE p.title LIKE %:keyword% "
            + "AND (:categoryid is null or p.category.id = :categoryid) "
            + "AND (:minprice is null or p.price >= :minprice) "
            + "AND (:maxprice is null or p.price <= :maxprice) AND p.isPublished = true AND p.isDeleted = false")
    List<Product> searchProducts(String keyword, Long categoryid, Double minprice, Double maxprice);
}
