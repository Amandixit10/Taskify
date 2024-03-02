package com.psl.taskManager.Service;

import java.util.List;

import com.psl.taskManager.Model.Task;
import com.psl.taskManager.dto.taskDto;

public interface Service {

	
	taskDto addTask(Task task);
	List<taskDto> getTask();
	List<taskDto> deleteTask(long id);
	List<taskDto> filter(String status);
	List<taskDto> sortTaskByDate(String status, String order);
	List<Task> overdueTask();
	void statusUpdate(List<Task> task);
}
