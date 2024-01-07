package org.intern.usertask.dao;

import java.util.Optional;

import org.intern.usertask.dto.Task;
import org.intern.usertask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDao {
	@Autowired
	private TaskRepository repository;

	public Task SaveTask(Task t) {
		return repository.save(t);
	}

	public Task UpdateTask(Task t) {
		return repository.save(t);
	}

	public Optional<Task> findById(int id) {
		return repository.findById(id);
	}

	public boolean deleteProduct(int id) {
		Optional<Task> rectask = findById(id);
		if (rectask.isPresent()) {
			repository.delete(rectask.get());
			return true;
		}
		return false;
	}
}
