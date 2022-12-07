package com.uniondata.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.uniondata.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> { // String = tipo do id dessa classe (Post);
	
	List<Post> findByTitleContainingIgnoreCase(String text); // Query Method, esta declaração já faz com que o Spring Data já monte pra gnt a consulta; Neste caso, busca posts contendo um dado String no título, ignorando minúsculas e maiúsculas;
}