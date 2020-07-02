package com.kd.example.es.services;

import com.kd.example.es.models.User;

public interface UserService {
	User create(User user);

	User update(User user);

	void delete(User user);

	void deleteById(String userId);

	User find(String id);

	Iterable<User> find();
}
