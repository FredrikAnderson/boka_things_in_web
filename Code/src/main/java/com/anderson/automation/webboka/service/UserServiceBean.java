package com.anderson.automation.webboka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.automation.webboka.infra.LocalUserRepository;
import com.anderson.automation.webboka.model.LocalUser;

@Service
public class UserServiceBean implements UserService {

	@Autowired
	private LocalUserRepository userRepo;
	
	@Override
	public LocalUser addUser(LocalUser userToAdd) {

		// Maybe some validation needs to happen
		
		return userRepo.save(userToAdd);
	}
	
}
