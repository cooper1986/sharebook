package com.lirun.sharebook.vo;

public class Students {
	
	private int id;
	private String name;
	private int classId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", classId=" + classId
				+ "]";
	}
	public Students() {
		// TODO Auto-generated constructor stub
	}
	public Students(int id,String name,int classid) {
		this.id = id;
		this.name = name;
		this.classId = classid;
	}
	
}
