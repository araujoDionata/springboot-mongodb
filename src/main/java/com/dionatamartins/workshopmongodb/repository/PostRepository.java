package com.dionatamartins.workshopmongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dionatamartins.workshopmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	//QueryMethods do MongoDB
	List<Post> findByTitleContainingIgnoreCase(String text);

}
