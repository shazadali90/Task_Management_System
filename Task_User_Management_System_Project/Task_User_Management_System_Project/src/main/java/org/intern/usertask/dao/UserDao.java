package org.intern.usertask.dao;

import java.util.List;
import java.util.Optional;

import org.intern.usertask.dto.User;
import org.intern.usertask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private UserRepository repository;

	public User SaveUser(User u) {
		return repository.save(u);
	}

	public User UpdateUser(User u) {
		return repository.save(u);
	}

	public void DeleteUser(int id) {
		repository.deleteById(id);
	}

	public List<User> findAll() {
		return repository.findAll();
	}

	public Optional<User> findById(int id) {
		return repository.findById(id);
	}

}
