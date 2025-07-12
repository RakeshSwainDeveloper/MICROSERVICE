package com.rks.microservices.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rks.microservices.inventory.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	boolean existsBySkuCodeAndQuantitytOrderIsGreaterThanEqual(String skuCode, Integer quantity);

}
