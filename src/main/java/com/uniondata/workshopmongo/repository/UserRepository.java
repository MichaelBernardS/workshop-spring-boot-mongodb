package com.uniondata.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.uniondata.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> { // String = tipo do id dessa classe (User);
}