package com.ofb.InventoryManagement.service;


import com.ofb.InventoryManagement.repository.ProductRepository;
import org.springframework.stereotype.Service;
import com.ofb.InventoryManagement.model.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public int getStock(Long productId) {
        return productRepository.findById(productId).map(Product::getStock).orElse(0);
    }

    @Transactional
    public Product addProduct(Product product) {
        Optional<Product> existingProduct = productRepository.findByName(product.getName());

        if (existingProduct.isPresent()) {
            Product existing = existingProduct.get();
            existing.setStock(existing.getStock() + product.getStock()); // Update stock
            return productRepository.save(existing); // Save updated product
        }

        return productRepository.save(product); // Save new product if not found
    }


}
