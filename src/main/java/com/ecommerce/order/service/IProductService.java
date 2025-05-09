package com.ecommerce.order.service;

import com.ecommerce.order.model.Product;

import java.util.Optional;

public interface IProductService {

    Optional<Product> createProduct(Product product);

    Optional<Product> updateProduct(Product product);
}
