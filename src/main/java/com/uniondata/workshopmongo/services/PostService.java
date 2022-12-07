package com.uniondata.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniondata.workshopmongo.domain.Post;
import com.uniondata.workshopmongo.repository.PostRepository;
import com.uniondata.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired // Spring instancia este objeto automaticamente;
	private PostRepository repo; // Pelo sistema de camadas, o serviço tem que conversar com o repositório;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text) {
		return repo.findByTitleContainingIgnoreCase(text); // Query Methods - Query especial que o SpringData oferece, que gera automaticamente as consultas; Neste caso, busca posts contendo um dado String no título, ignorando minúsculas e maiúsculas;
	}
}

// Serviço responsável por trabalhar com usuários;