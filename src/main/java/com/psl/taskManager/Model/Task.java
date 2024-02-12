package com.psl.taskManager.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Tasks")
public class Task {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Long taskId;
private String taskDetails;
private String title;
private Date startDate;
private Date dueDate;
private String status;
public Long getTaskId() {
	return taskId;
}
public void setTaskId(Long taskId) {
	this.taskId = taskId;
}
public String getTaskDetails() {
	return taskDetails;
}
public void setTaskDetails(String taskDetails) {
	this.taskDetails = taskDetails;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public Date getStartDate() {
	return startDate;
}
public void setStartDate(Date startDate) {
	this.startDate = startDate;
}
public Date getDueDate() {
	return dueDate;
}
public void setDueDate(Date dueDate) {
	this.dueDate = dueDate;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "Task [taskId=" + taskId + ", taskDetails=" + taskDetails + ", title=" + title + ", startDate=" + startDate
			+ ", dueDate=" + dueDate + ", status=" + status + "]";
}
public Task(Long taskId, String taskDetails, String title, Date startDate, Date dueDate, String status) {
	super();
	this.taskId = taskId;
	this.taskDetails = taskDetails;
	this.title = title;
	this.startDate = startDate;
	this.dueDate = dueDate;
	this.status = status;
}
public Task() {
	super();
	// TODO Auto-generated constructor stub
}

}