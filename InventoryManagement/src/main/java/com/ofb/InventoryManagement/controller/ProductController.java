package com.ofb.InventoryManagement.controller;

import com.ofb.InventoryManagement.model.Product;
import com.ofb.InventoryManagement.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PutMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product response= productService.addProduct(product);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{productId}/stockInHand")
    public ResponseEntity<Integer> getStock(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.getStock(productId));
    }
}
