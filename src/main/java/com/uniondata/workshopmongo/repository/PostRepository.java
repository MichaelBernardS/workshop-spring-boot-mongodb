package com.uniondata.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.uniondata.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> { // String = tipo do id dessa classe (Post);	
}