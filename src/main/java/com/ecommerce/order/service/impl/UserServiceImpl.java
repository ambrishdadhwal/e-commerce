package com.ecommerce.order.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecommerce.order.model.User;
import com.ecommerce.order.repository.UserRepository;
import com.ecommerce.order.service.IUserService;

import lombok.RequiredArgsConstructor;

@Service("userService")
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService
{

	private final UserRepository userRepository;

	@Override
	public Optional<User> saveUser(User user) throws Exception {
		Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
		if (existingUser.isPresent())
		{
			throw new Exception("User already exist with email - " + user.getEmail());
		}
		return Optional.of(userRepository.save(user));
	}

	@Override
	public Optional<User> updateUser(User user)
	{
		User updateUser = new User();
		updateUser.setId(user.getId());
		updateUser.setFirstName(user.getFirstName());
		updateUser.setLastName(user.getLastName());
		return Optional.of(userRepository.save(updateUser));
	}

	@Override
	public Optional<User> deleteUser(String userId) throws Exception
	{
		Optional<User> user = userRepository.findByIdAndIsDeleted(userId, false);
		if (!user.isPresent())
		{
			throw new Exception("User not found");
		}
		User existingUser = user.get();
		existingUser.setIsDeleted(true);
		userRepository.save(existingUser);
		return Optional.of(existingUser);
	}

	@Override
	public Optional<User> getUser(String userId)
	{
		return userRepository.findById(userId);
	}

	@Override
	public List<User> getUsers()
	{
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
