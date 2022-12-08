package com.uniondata.workshopmongo.services;

import java.util.Date;
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
		return repo.searchTitle(text); // Query Methods - Query especial que o SpringData oferece, que gera automaticamente as consultas; Neste caso, busca posts contendo um dado String no título, ignorando minúsculas e maiúsculas;
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000); // Adicionando 24hrs pegando o instante atual, e adicionando; Pois para achar um determinado dia, tem que percorrer TODO esse dia, por isto, faremos este macete de incrementar 1 dia em milisegundos;
		return repo.fullSearch(text, minDate, maxDate);
	}
}

// Serviço responsável por trabalhar com posts;