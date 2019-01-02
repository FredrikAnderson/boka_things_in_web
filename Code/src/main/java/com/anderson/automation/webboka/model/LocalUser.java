package com.anderson.automation.webboka.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class LocalUser {

    @Id    
    private String userName;

    private String password;

    private String firstName;

    private String lastName;
    

    @OneToMany
    private Set<Authority> authorities = new HashSet<>();
    
    private Boolean enabled;
    
    private Date changedDate;
    
    
    public LocalUser() {}

    public LocalUser(String name) {
        this.setUserName(name);
    }
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Date getChangedDate() {
		return changedDate;
	}

	public void setChangedDate(Date changedDate) {
		this.changedDate = changedDate;
	}

	
    @Override
    public String toString() {
        return String.format("LocalUser [userName='%s']", getUserName());
    }

}

