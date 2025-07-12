package com.rks.microservices.production.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rks.microservices.production.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
