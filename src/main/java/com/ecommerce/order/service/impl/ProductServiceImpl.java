package com.ecommerce.order.service.impl;

import com.ecommerce.order.model.Product;
import com.ecommerce.order.repository.ProductRepository;
import com.ecommerce.order.service.IProductService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("productService")
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public Optional<Product> createProduct(Product product) {
        return Optional.of(productRepository.save(product));
    }

    @Override
    public Optional<Product> updateProduct(Product product) {
        return Optional.of(productRepository.save(product));
    }
}
