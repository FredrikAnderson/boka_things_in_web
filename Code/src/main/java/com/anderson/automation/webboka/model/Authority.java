package com.anderson.automation.webboka.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Authority {

	@Id
	private String authority;

	@ManyToOne
	@JoinColumn(name = "USERNAME")
	private LocalUser localUser;

	
	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public LocalUser getLocalUser() {
		return localUser;
	}

	public void setLocalUser(LocalUser localUser) {
		this.localUser = localUser;
	}
	

}
