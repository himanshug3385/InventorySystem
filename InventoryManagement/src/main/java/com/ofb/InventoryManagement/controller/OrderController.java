package com.ofb.InventoryManagement.controller;

import com.ofb.InventoryManagement.DTO.BuyerOrdersResponse;
import com.ofb.InventoryManagement.DTO.OrderRequest;
import com.ofb.InventoryManagement.model.Order;
import com.ofb.InventoryManagement.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{productId}/buyer/{buyerId}/order")
    public ResponseEntity<Order> orderProduct(
            @PathVariable Long productId,
            @PathVariable Long buyerId,
            @RequestBody OrderRequest request) {
        return ResponseEntity.ok(orderService.orderProduct(productId, buyerId, request.getQuantity()));
    }

    @GetMapping("/order")
    public ResponseEntity<List<BuyerOrdersResponse>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllBuyerOrders());
    }
}
