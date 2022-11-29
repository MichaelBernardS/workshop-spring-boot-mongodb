package com.uniondata.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniondata.workshopmongo.domain.User;
import com.uniondata.workshopmongo.repository.UserRepository;
import com.uniondata.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired // Spring instancia este objeto automaticamente;
	private UserRepository repo; // Pelo sistema de camadas, o serviço tem que conversar com o repositório;
	
	public List<User> findAll() {
		return repo.findAll(); // Método já existente no repository, que puxa tds os usuários do banco de dados;
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}

// Serviço responsável por trabalhar com usuários;