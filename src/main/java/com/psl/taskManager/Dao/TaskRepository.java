package com.psl.taskManager.Dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.psl.taskManager.Model.Task;

import jakarta.transaction.Transactional;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

	@Query(value = "select * from tasks t where t.status =:status", nativeQuery = true)
	List<Task> getTaskByStatus(String status);
	
	@Query(value = "select * from tasks t where t.due_date<:date", nativeQuery = true)
	List<Task> getOverdueTaskList(Date date);
	
	
	@Modifying
	@Transactional
<<<<<<< HEAD
	@Query(value="update Tasks t set t.status=:status where t.task_id=:id ",nativeQuery=true)
=======
	@Query(value="update Tasks t set t.status=:status where t.task_Id=:id ",nativeQuery=true)
>>>>>>> ba688e7c520cddc0840607a40775d22586b59f9b
	public int updateTaskStatus(@Param("id") Long id, @Param("status") String status);

}

// https://meet.google.com/rzb-regw-dvb
