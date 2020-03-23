package com.metacube.metaparkingsystemv2.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.metacube.metaparkingsystemv2.dao.UserRepository;
import com.metacube.metaparkingsystemv2.models.User;
import com.metacube.metaparkingsystemv2.principal.MyUserDetails;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);
		user.orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found."));
		return user.map(MyUserDetails::new).get();
	}

}
