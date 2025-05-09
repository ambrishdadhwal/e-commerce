package com.ecommerce.order.repository;

import com.ecommerce.order.model.Product;
import com.ecommerce.order.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository  extends MongoRepository<Product, String> {
}
