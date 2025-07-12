package com.rks.microservices.production.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rks.microservices.production.dto.ProductRequest;
import com.rks.microservices.production.dto.ProductResponse;
import com.rks.microservices.production.model.Product;
import com.rks.microservices.production.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

	private final ProductRepository productRepository;

	public ProductResponse createProduct(ProductRequest productRequest) {
		Product product = Product.builder().name(productRequest.name()).description(productRequest.description())
				.price(productRequest.price()).build();
		Product save = productRepository.save(product);
		log.info("PRODUCT CREATED SUCCESSFULLY");
		return new ProductResponse(save.getId(), save.getName(), save.getDescription(), save.getPrice());
	}

	public List<ProductResponse> getAllProduct() {
		return productRepository.findAll().stream().map(product -> new ProductResponse(product.getId(),
				product.getName(), product.getDescription(), product.getPrice())).collect(Collectors.toList());
	}

}
