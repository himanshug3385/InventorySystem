package com.ofb.InventoryManagement.controller;

import com.ofb.InventoryManagement.model.Buyer;
import com.ofb.InventoryManagement.service.BuyerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/buyer")
public class BuyerController {

    private final BuyerService buyerService;

    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @PutMapping
    public ResponseEntity<Buyer> createBuyer(@RequestBody Buyer buyer) {
        return ResponseEntity.ok(buyerService.saveBuyer(buyer));
    }
}
