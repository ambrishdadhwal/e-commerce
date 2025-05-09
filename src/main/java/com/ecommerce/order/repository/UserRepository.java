package com.ecommerce.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecommerce.order.model.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String>
{
    Optional<User> findByIdAndIsDeleted(String userId, Boolean delete);

    Optional<User> findByEmail(String email);
}
