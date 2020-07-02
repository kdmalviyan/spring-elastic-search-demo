package com.kd.example.es.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kd.example.es.models.User;
import com.kd.example.es.repository.ElasticSearchUserRepository;

@Service
public class ElasticSearchUserService implements UserService {

	@Autowired
	ElasticSearchUserRepository elasticSearchUserRepository;

	@Override
	public User create(User user) {
		user = elasticSearchUserRepository.save(user);
		return user;
	}

	@Override
	public User update(User user) {
		user = elasticSearchUserRepository.save(user);
		return user;
	}

	@Override
	public void delete(User user) {
		elasticSearchUserRepository.delete(user);
	}

	@Override
	public void deleteById(String userId) {
		elasticSearchUserRepository.deleteById(userId);
	}

	@Override
	public User find(String id) {
		User user = elasticSearchUserRepository.findById(id).orElse(null);
		return user;
	}

	@Override
	public Iterable<User> find() {
		Iterable<User> users = elasticSearchUserRepository.findAll();
		return users;
	}

}
