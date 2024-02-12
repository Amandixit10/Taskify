package com.psl.taskManager.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.psl.taskManager.Model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

	@Query(value = "select * from Tasks t where t.status =:status", nativeQuery = true)
	List<Task> getTaskByStatus(String status);
	

}
