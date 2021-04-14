package com.jhm.admdash.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jhm.admdash.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByNameAndPassword(String name, String password);
	
}
