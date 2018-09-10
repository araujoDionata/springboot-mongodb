package com.dionatamartins.workshopmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dionatamartins.workshopmongodb.domain.User;
import com.dionatamartins.workshopmongodb.repository.userRepository;

@Service
public class UserService {

	@Autowired
	private userRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
