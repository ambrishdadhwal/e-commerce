package com.ecommerce.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecommerce.order.model.User;

public interface UserRepository extends MongoRepository<User, String>
{

}
