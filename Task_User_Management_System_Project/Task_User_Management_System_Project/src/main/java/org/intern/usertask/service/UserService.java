package org.intern.usertask.service;

import java.util.Optional;

import org.intern.usertask.dao.UserDao;
import org.intern.usertask.dto.ResponseStructure;
import org.intern.usertask.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<User>> SaveUser(User u) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setData(userDao.SaveUser(u));
		structure.setMessage("User Saved With Id:" + u.getId());
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> UpdateUser(User u) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setData(userDao.UpdateUser(u));
		structure.setMessage("User Updated");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<String>> DeleteUser(int id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<User> recUser = userDao.findById(id);
		if (recUser.isPresent()) {
			structure.setMessage("User deleted");
			structure.setData("User found");
			structure.setStatusCode(HttpStatus.OK.value());
			userDao.DeleteUser(id);
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		return null;
	}
}
