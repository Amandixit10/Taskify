package com.psl.taskManager.dto;

public class taskDto {
	private Long taskId;
	private String taskDetails;
	private String title;
	private String startDate;
	private String dueDate;
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
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
	public taskDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public taskDto(Long taskId, String taskDetails, String title, String startDate, String dueDate, String status) {
		super();
		this.taskId = taskId;
		this.taskDetails = taskDetails;
		this.title = title;
		this.startDate = startDate;
		this.dueDate = dueDate;
		this.status = status;
	}
	
}
