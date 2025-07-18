package com.rks.microservices.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "inventory", url = "http://localhost:8082")
public interface InventoryClient {

//	@RequestMapping(method = RequestMethod.GET, value = "/api/inventory")
	@GetMapping("/api/inventory")
	boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);

}
