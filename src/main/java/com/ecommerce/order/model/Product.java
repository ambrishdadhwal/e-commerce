package com.ecommerce.order.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "Products")
@Data
@SuperBuilder
public class Product {

    @MongoId
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private String category;
    private int stock;
    private List<String> imageUrls;
    private double rating;
    private boolean isActive;
    private String createdBy;
    @CreatedDate
    private LocalDateTime createDateTime;
    @LastModifiedDate
    private LocalDateTime modifiedDateTime;
}
