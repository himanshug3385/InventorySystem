package com.ofb.InventoryManagement.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class BuyerOrdersResponse {
    private String buyerName;
    private String productName;
    private int quantity;
}
