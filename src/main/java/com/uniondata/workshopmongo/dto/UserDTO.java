package com.uniondata.workshopmongo.dto;

import java.io.Serializable;

import com.uniondata.workshopmongo.domain.User;

public class UserDTO implements Serializable {	

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	
	public UserDTO() {
	}
	
	public UserDTO(User obj) { // Forma automatizada para instanciar um UserDTO a partir de um User; Construtor para instanciar a partir do objeto entity correspondente;
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
}