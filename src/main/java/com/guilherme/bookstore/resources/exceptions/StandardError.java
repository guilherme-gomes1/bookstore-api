package com.guilherme.bookstore.resources.exceptions;

public class StandardError {

	private Long timestamo;
	private Integer status;
	private String error;

	public StandardError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StandardError(Long timestamo, Integer status, String error) {
		super();
		this.timestamo = timestamo;
		this.status = status;
		this.error = error;
	}

	public Long getTimestamo() {
		return timestamo;
	}

	public void setTimestamo(Long timestamo) {
		this.timestamo = timestamo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
