package com.demo.student.responses;

import java.time.LocalDateTime;

public class ErrorInfo {
	
	private LocalDateTime timestamp;
	private String status;
	private String error;
	private String path;
	
	
	public ErrorInfo(LocalDateTime timestamp, String status, String error, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.path = path;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
