package com.rks.microservices.inventory.service;

import org.springframework.stereotype.Service;

import com.rks.microservices.inventory.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

	private final InventoryRepository inventoryRepository;

	public boolean isInStock(String skuCode, Integer quantity) {
		// Find an inventory for a given skuCode and quantitytOrder is greater than 0
		return inventoryRepository.existsBySkuCodeAndQuantitytOrderIsGreaterThanEqual(skuCode, quantity);
	}

}
