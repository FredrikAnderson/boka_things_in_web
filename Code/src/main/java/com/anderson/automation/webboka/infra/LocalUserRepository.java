package com.anderson.automation.webboka.infra;

import org.springframework.data.repository.CrudRepository;

import com.anderson.automation.webboka.model.LocalUser;

public interface LocalUserRepository extends CrudRepository<LocalUser, Long> {

	LocalUser findUserByUsername(String username);
}
