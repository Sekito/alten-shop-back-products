package com.bem.productmanagement.service;


import com.bem.productmanagement.exception.ResourceNotFoundException;
import com.bem.productmanagement.model.Product;
import com.bem.productmanagement.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product Not Found- id="+id));
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = this.getProductById(id);
        //Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product Not Found- id="+id));
        product.setCode(productDetails.getCode());
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setQuantity(productDetails.getQuantity());
        product.setInventoryStatus(productDetails.getInventoryStatus());
        product.setCategory(productDetails.getCategory());
        product.setImage(productDetails.getImage());
        product.setRating(productDetails.getRating());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        Product product = this.getProductById(id);
        productRepository.delete(product);
    }
}