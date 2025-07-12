package com.rks.microservices.order.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rks.microservices.order.InventoryClient;
import com.rks.microservices.order.dto.OrderRequest;
import com.rks.microservices.order.model.Order;
import com.rks.microservices.order.repository.OrderRepositry;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepositry orderRepositry;
	private final InventoryClient inventoryClient;

	public void placeOrder(OrderRequest orderRequest) {

		var isInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

		if (!isInStock) {
			throw new RuntimeException("Product with SkuCode " + orderRequest.skuCode() + " is not in stock");
		}

		Order order = Order.builder().id(orderRequest.id()).orderNumber(UUID.randomUUID().toString())
				.skuCode(orderRequest.skuCode()).price(orderRequest.price()).quantity(orderRequest.quantity()).build();
		orderRepositry.save(order);
	}

}
