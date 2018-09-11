package com.dionatamartins.workshopmongodb.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.dionatamartins.workshopmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	// QueryMethods do MongoDB
	List<Post> findByTitleContainingIgnoreCase(String text);

	// https://docs.mongodb.com/manual/reference/operator/query/regex/
	// ?0 = primeiro parametro do metodo (String text)
	// i = option camel case ignore
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);

	@Query("{ $and: [ { date: {$gte: ?1} }, { date: {$lte: ?2} } ,{ $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
