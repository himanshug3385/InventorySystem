package com.ofb.InventoryManagement.service;


import com.ofb.InventoryManagement.DTO.BuyerOrdersResponse;
import com.ofb.InventoryManagement.model.Buyer;
import com.ofb.InventoryManagement.model.Order;
import com.ofb.InventoryManagement.model.Product;
import com.ofb.InventoryManagement.repository.BuyerRepository;
import com.ofb.InventoryManagement.repository.OrderRepository;
import com.ofb.InventoryManagement.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final BuyerRepository buyerRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository, BuyerRepository buyerRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.buyerRepository = buyerRepository;
    }

    @Transactional
    public Order orderProduct(Long productId, Long buyerId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        Buyer buyer = buyerRepository.findById(buyerId)
                .orElseThrow(() -> new RuntimeException("Buyer not found"));

        if (product.getStock() < quantity) {
            throw new RuntimeException("Insufficient stock!");
        }

        // Update stock and persist product
        product.setStock(product.getStock() - quantity);
        productRepository.save(product);  // Ensure it's properly updated in the DB

        // Use @GeneratedValue for Order ID instead of manually setting it
        Order order = new Order(null, buyerId, productId, quantity);
        return orderRepository.save(order);
    }

    public List<BuyerOrdersResponse> getAllBuyerOrders() {
        List<Order> orderList= orderRepository.findAll();
        List<BuyerOrdersResponse>response =new ArrayList<>();
        for(Order order:orderList){
            Optional<Buyer> buyer= buyerRepository.findById(order.getBuyerId());
            Optional<Product> product=productRepository.findById(order.getProductId());
            String buyerName=buyer.get().getName();
            String productName=product.get().getName();
            BuyerOrdersResponse buyerOrdersResponse=new BuyerOrdersResponse(buyerName,productName,order.getQuantity());
            response.add(buyerOrdersResponse);
        }
        return response;
    }
}
