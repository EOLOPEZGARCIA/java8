package com.resttemplatems.service;

//import com.like.a.shark.resttemplatems.dto.UserDTO;
import com.resttemplatems.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
	
	//@Value("${spring.external.service.base-url}")
	private String basePath = "https://65e944634bb72f0a9c510b49.mockapi.io";// = "https://65e944634bb72f0a9c510b49.mockapi.io";
	
	private final RestTemplate restTemplate = new RestTemplate();

	public List<UsuarioDTO> getUsers(){
		System.out.println("Aqui  2");
		System.out.println(basePath);
		UsuarioDTO[]response = restTemplate.getForObject(basePath + "/users", UsuarioDTO[].class);
		System.out.println(response);
		return Arrays.asList(response);
	}
	
	public void saveUser(UsuarioDTO user){
		restTemplate.postForObject(basePath + "/users", user, UsuarioDTO.class);
	}
	
	public void updateUser(Integer id,UsuarioDTO user){
		restTemplate.put(basePath + "/users/" + id, user); 
	}
	
	public void deleteUser(Integer id){
		restTemplate.delete(basePath + "/users/" + id);
	}
	
}
