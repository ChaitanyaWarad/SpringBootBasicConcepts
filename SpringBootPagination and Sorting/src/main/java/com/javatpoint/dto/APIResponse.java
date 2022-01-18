package com.javatpoint.dto;


public class APIResponse<T> {

	int readcount;
	T response;

	public APIResponse(int readcount, T response) {
		super();
		this.readcount = readcount;
		this.response = response;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}

}
