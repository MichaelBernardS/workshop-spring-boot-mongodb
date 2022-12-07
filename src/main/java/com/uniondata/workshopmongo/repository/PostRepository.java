package com.uniondata.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.uniondata.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> { // String = tipo do id dessa classe (Post);
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }") // Colocar a consulta JSON; ?0 é o primeiro parametro do método, que é o text; i para ignorar maiúsculas e minúsculas;
	List<Post> searchTitle(String text); // Método personalizado, pode por o nome q quiser;
	
	List<Post> findByTitleContainingIgnoreCase(String text); // Query Method, esta declaração já faz com que o Spring Data já monte pra gnt a consulta; Neste caso, busca posts contendo um dado String no título, ignorando minúsculas e maiúsculas;
}