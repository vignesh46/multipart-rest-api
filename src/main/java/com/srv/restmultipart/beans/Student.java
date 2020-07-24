package com.srv.restmultipart.beans;

public class Student {
	private String id;

	public Student () {
		
	}
	
	public Student(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + "]";
	}
	
	
	
}
