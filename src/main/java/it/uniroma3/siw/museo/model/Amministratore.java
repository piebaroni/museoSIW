package it.uniroma3.siw.museo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Amministratore {

	private String password;
	
	@Id
	private String userName;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
