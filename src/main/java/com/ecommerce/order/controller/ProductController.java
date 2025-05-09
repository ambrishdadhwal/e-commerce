package com.ecommerce.order.controller;

import com.ecommerce.order.model.Product;
import com.ecommerce.order.model.User;
import com.ecommerce.order.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private  final IProductService productService;

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Product> createUser(@RequestBody @Validated Product product) throws Exception
    {
        return ResponseEntity.ok(productService.createProduct(product).get());
    }

    @PutMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Product> updateUser(@RequestBody @Validated Product product) throws Exception
    {
        return ResponseEntity.ok(productService.updateProduct(product).get());
    }
}
