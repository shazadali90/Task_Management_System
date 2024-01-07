package org.intern.usertask.service;

import java.util.Optional;

import org.intern.usertask.dao.TaskDao;
import org.intern.usertask.dao.UserDao;
import org.intern.usertask.dto.ResponseStructure;
import org.intern.usertask.dto.Task;
import org.intern.usertask.dto.User;
import org.intern.usertask.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
	@Autowired
	private TaskDao taskDao;
	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<Task>> SaveTask(Task task, int user_id) {
		Optional<User> recUser = userDao.findById(user_id);
		ResponseStructure<Task> structure = new ResponseStructure<>();
		if (recUser.isPresent()) {
			User u = recUser.get();
			u.getTasks().add(task);
			task.setUser(recUser.get());
			userDao.UpdateUser(u);
			taskDao.SaveTask(task);
			structure.setData(task);
			structure.setMessage("Task added Succesfully");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Task>>(structure, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Task>> UpdateTask(Task task, int user_id) {
		Optional<User> recUser = userDao.findById(user_id);
		ResponseStructure<Task> structure = new ResponseStructure<>();
		if (recUser.isPresent()) {
			task.setUser(recUser.get());
			taskDao.SaveTask(task);
			structure.setData(task);
			structure.setMessage("Task Updated succesfully");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Task>>(structure, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}

}
