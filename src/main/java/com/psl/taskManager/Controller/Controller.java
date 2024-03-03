package com.psl.taskManager.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.psl.taskManager.Model.Task;
import com.psl.taskManager.Service.ServiceInterface;
import com.psl.taskManager.dto.taskDto;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {

	@Autowired
	private ServiceInterface taskService;
	
	@PostMapping("/addTask")
	public taskDto addtask(@RequestBody Task task)
	{
	return taskService.addTask(task);	
	}

	@GetMapping("/getTask")
	public List<taskDto> getTask()
	{
		System.out.println("Api hit");
		return taskService.getTask();
	}
	
	@DeleteMapping("/deleteTask")
	 public List<taskDto> deleteTask(@RequestBody taskDto task)
	{
	return taskService.deleteTask(task.getTaskId());	
	}
	
	@GetMapping("/getTask/{status}")
	public List<taskDto> getTaskByStatus(@PathVariable String status)
	{
	return taskService.filter(status);	
	}
	
	@GetMapping("/getTask/sort")
	public List<taskDto> SortTask(@RequestParam Map<String, String> params)
	{
		System.out.println("Hi");
	String status=params.get("status");
	String order=params.get("order");
	System.out.println(status+" "+order);
	return taskService.sortTaskByDate(status,order);
	}
	@GetMapping("/getTask/overdue")
	public List<Task> overTaskList()
	{
		return taskService.overdueTask();
	}
}
