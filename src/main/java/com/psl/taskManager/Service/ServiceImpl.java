package com.psl.taskManager.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import com.psl.taskManager.Dao.TaskRepository;
import com.psl.taskManager.Model.Task;
import com.psl.taskManager.dto.taskDto;

@org.springframework.stereotype.Service 
public class ServiceImpl implements Service{

	@Autowired
	private TaskRepository taskRepo;
	
	@Override
	public taskDto addTask(Task task) {
		task.setStartDate(Calendar.getInstance().getTime());
		task.setStatus("in progress");
		 taskRepo.save(task);
		 taskDto dto=new taskDto();
			dto.setStatus(task.getStatus());
			dto.setTaskDetails(task.getTaskDetails());
			dto.setTaskId(task.getTaskId());
			dto.setTitle(task.getTitle());
			dto.setStartDate(Converter(Calendar.getInstance().getTime()));
			dto.setDueDate(Converter(task.getDueDate()));
		 return dto;
	}
	
	@Override
	public List<taskDto> getTask() {
		// TODO Auto-generated method stub
		List<Task> taskList=taskRepo.findAll();
		
		return Converter(taskList);
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<taskDto> deleteTask(long id) {
		taskRepo.delete(taskRepo.getById(id));
		List<Task> taskList=taskRepo.findAll();
		return Converter(taskList);
	}

	@Override
	public List<taskDto> filter(String status) {
		List<Task> taskList=taskRepo.getTaskByStatus(status);
		return Converter(taskList);
	}

	@Override
	public List<taskDto> sortTaskByDate(String status, String order) {
		if(order.equals("DESC"))
		{
			return Converter(taskRepo.findAll(Sort.by(Sort.Direction.DESC,status)));
		}
		
		return Converter(taskRepo.findAll(Sort.by(Sort.Direction.ASC,status)));
	}
public String Converter(Date date)
{
	DateFormat df = new SimpleDateFormat("dd-MM-yy");;
	String formattedDateTime=df.format(date);
	return formattedDateTime;
}

public List<taskDto> Converter(List<Task> taskList)
{
	List<taskDto> list=new ArrayList<>();
	for(Task i:taskList)
	{
		taskDto dto=new taskDto();
		dto.setStatus("in progress");
		dto.setTaskDetails(i.getTaskDetails());
		dto.setTaskId(i.getTaskId());
		dto.setTitle(i.getTitle());
		dto.setStartDate(Converter(Calendar.getInstance().getTime()));
		dto.setDueDate(Converter(i.getDueDate()));
		list.add(dto);
	}
	return list;	
}

}
