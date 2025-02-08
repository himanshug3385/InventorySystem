package com.ofb.InventoryManagement.repository;



import com.ofb.InventoryManagement.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {
}
