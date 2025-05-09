package com.ecommerce.order.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.order.model.User;

public interface IUserService
{

	public Optional<User> saveUser(User user) throws Exception;

	public Optional<User> updateUser(User user);

	public Optional<User> deleteUser(String userId) throws Exception;

	public Optional<User> getUser(String userId);

	public List<User> getUsers();

	public Optional<User> getUserByEmail(String email);
}
