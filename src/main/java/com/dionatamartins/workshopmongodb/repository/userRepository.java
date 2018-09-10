package com.dionatamartins.workshopmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dionatamartins.workshopmongodb.domain.User;

@Repository
public interface userRepository extends MongoRepository<User, String> {

}
