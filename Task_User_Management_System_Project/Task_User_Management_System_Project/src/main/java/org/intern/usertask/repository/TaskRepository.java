package org.intern.usertask.repository;

import org.intern.usertask.dto.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
