package com.resttemplatems.dto;

import lombok.Data;

@Data
public class UsuarioDTO {

	private Integer id;
	private String name;
	private String username;
	private String email;
	private String avatar;
	
	public UsuarioDTO() {
		
	}
	
	public UsuarioDTO(Integer id, String name, String username, String email, String avatar) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.avatar = avatar;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	
}
