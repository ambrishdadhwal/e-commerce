package com.ecommerce.order.security;

import java.util.Optional;

import com.ecommerce.order.model.User;
import com.ecommerce.order.service.IUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService
{

	final IUserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		log.info("Inside CustomUserDetailsService.loadUserByUsername .....");
		Optional<User> currentUser = userService.getUserByEmail(username);

		if (currentUser.isPresent())
		{
			User user = currentUser.get();
			return null;
		}

		throw new UsernameNotFoundException("User not found with username :-" + username);
	}
}
