package com.watiti.productservice.ServiceImpl;

import com.watiti.productservice.exception.NoSuchResourceException;
import com.watiti.productservice.model.Product;
import com.watiti.productservice.repository.ProductRepository;
import com.watiti.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl  implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public Product addProduct(Product product) {
       return productRepository.save(product);
    }

    @Override
    public Product getProduct(long productId) throws NoSuchResourceException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchResourceException("No Product found  with", productId));

        return product;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
     /*o1.ifPresentOrElse(s -> System.out.println("Found " + s),
        () -> System.out.println("Not found"));*/

    @Override
    public Product editProduct(long productID, Product edit_product) {
        Product product = productRepository.findById(productID)
                .orElseThrow(() -> new NoSuchResourceException("No product found  with", productID));

        product.setAttributes(edit_product.getAttributes());
        product.setCategory(edit_product.getCategory());
        product.setCreationDate(edit_product.getCreationDate());
        product.setDescription(edit_product.getDescription());
        product.setImageUrl(edit_product.getImageUrl());
        product.setPrice(edit_product.getPrice());
        product.setTitle(edit_product.getTitle());
        product.setPublished(edit_product.isPublished());
        product.setStockAmount(edit_product.getStockAmount());
        product.setDeleted(edit_product.isDeleted());

        return productRepository.save(product);
    }

    @Override
    public Product deleteProduct(long productId) throws NoSuchResourceException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchResourceException("No Product found  with", productId));

        product.setDeleted(true);
        productRepository.save(product);

        return productRepository.save(product);
      //  oldProduct.ifPresentOrElse(return oldProduct, return null);
    }

    @Override
    public Product updateStock(long soldAmount, long productId) {
        return null;
    }

    @Override
    public List<Product> findByTitle(String title) {
        return null;
    }

    @Override
    public List<Product> findByTitleAndDescription(String title, String description) {
        //turn productRepository.findByTitle();
        return productRepository.findByTitleAndDescription(title, description);

}
    @Override
    public List<Product> findByCategoryName(String name) {
        return null;
    }

    @Override
    public List<Product> getVendorProducts(long vendorId) {
        return null;
    }

    @Override
    public Product createProductWithImage(MultipartFile image, Product product) {
        return null;
    }

    @Override
    public Product updateProductWithImage(MultipartFile image, Product product) {
        return null;
    }

    @Override
    public List<Product> getVendorPublishedProducts(long vendorId) {
        return null;
    }

    @Override
    public List<Product> getVendorNonPublishedProducts(long vendorId) {
        return null;
    }

    @Override
    public List<Product> getNonDeletedProducts() {
        return null;
    }

    @Override
    public List<Product> getDeletedProducts() {
        return null;
    }

    @Override
    public List<Product> getPublishedProducts() {
        return null;
    }

    @Override
    public List<Product> getNonPublishedProducts() {
        return null;
    }

    @Override
    public List<Product> findAllProductIn(List<Long> ProductIds) {
        return null;
    }

    @Override
    public List<Product> search(String keyword, Long categoryid, Double minprice, Double maxprice) {
        return null;
    }
}
