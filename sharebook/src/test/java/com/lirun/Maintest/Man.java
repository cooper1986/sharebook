package com.lirun.Maintest;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.lirun.DynamicProxy.Itarget;

public class Man implements Person,Itarget{

	private int id;
	private String name;
	private int classId;
	public int test_id;
	
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
	Logger log = Logger.getLogger(this.getClass());
	public void run(){
		System.out.println("Man's run ...");
	}
	public Man(){
		
	}
	public Man(int id,String name,int classid){
		this.id = id;
		this.name = name;
		this.classId = classid;
	}
	
}
