package com.anderson.automation.webboka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anderson.automation.webboka.infra.LocalUserRepository;
import com.anderson.automation.webboka.model.LocalUser;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private LocalUserRepository userDetailsRepo;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		LocalUser user = userDetailsRepo.findUserByUserName(username);
		UserBuilder builder = null;
		if (user != null) {

			builder = org.springframework.security.core.userdetails.User.withUsername(username);
//      builder.disabled(!user.isEnabled());
			builder.disabled(false);
			builder.password(user.getPassword());
//      String[] authorities = user.getAuthorities()
//          .stream().map(a -> a.getAuthority()).toArray(String[]::new);
//      builder.authorities(authorities);

		} else {
			throw new UsernameNotFoundException("User not found.");
		}
		return builder.build();
	}
}
