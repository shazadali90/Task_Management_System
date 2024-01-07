package org.intern.usertask.controller;

import org.intern.usertask.dto.ResponseStructure;
import org.intern.usertask.dto.Task;
import org.intern.usertask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TaskController {
	@Autowired
	private TaskService service;

	@PostMapping("/task/{user_id}")
	public ResponseEntity<ResponseStructure<Task>> SaveTask(@RequestBody Task task, @PathVariable int user_id) {
		return service.SaveTask(task, user_id);
	}

	@PutMapping("/task/{user_id}")
	public ResponseEntity<ResponseStructure<Task>> UpdateTask(@RequestBody Task task, @PathVariable int user_id) {
		return service.UpdateTask(task, user_id);
	}
}
