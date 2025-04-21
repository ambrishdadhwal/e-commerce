package com.ecommerce.order.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecommerce.order.model.User;
import com.ecommerce.order.repository.UserRepository;
import com.ecommerce.order.service.IUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService
{

	private final UserRepository userRepository;

	@Override
	public Optional<User> saveUser(User user)
	{
		return Optional.ofNullable(userRepository.save(user));
	}

	@Override
	public Optional<User> updateUser(User user)
	{
		return Optional.ofNullable(userRepository.save(user));
	}

	@Override
	public Optional<User> deleteUser(String userId) throws Exception
	{
		Optional<User> user = userRepository.findById(userId);
		if (!user.isPresent())
		{
			throw new Exception("User not found");
		}
		User existingUser = user.get();
		existingUser.setIsDeleted(true);
		userRepository.save(existingUser);
		return Optional.ofNullable(existingUser);
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

}
