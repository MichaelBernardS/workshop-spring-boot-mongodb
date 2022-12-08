package com.uniondata.workshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.uniondata.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> { // String = tipo do id dessa classe (Post);
	
	// @Query - Método personalizado
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }") // Colocar a consulta JSON; ?0 é o primeiro parametro do método, que é o text; i para ignorar maiúsculas e minúsculas;
	List<Post> searchTitle(String text);
	
	// Query Method
	
	List<Post> findByTitleContainingIgnoreCase(String text); // Esta declaração já faz com que o Spring Data já monte pra gnt a consulta; Neste caso, busca posts contendo um dado String no título, ignorando minúsculas e maiúsculas;

	// @Query - Consulta com vários critérios
	
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} }, { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }") // Operador "ou" pois vai ter q buscar o texto ou no título, ou no corpo, ou nos comentários; Dps "e" para data mínima e data máxima; Comparison Query Operators: $gte = (greater than or equal to) maior ou igual; ?1 segundo parâmetro (minDate); $lte = (less than or equal to) menor ou igual; ?2 terceiro parâmetro (maxDate); comments.text - comments é a lista de comentários, e eu só quero o texto de cada comentários do post;
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
}