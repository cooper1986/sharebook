package com.lirun.AdapterObject;

public class Adapter implements Itarget{

	private Adaptee adaptee;
	public Adapter(Adaptee adaptee){
		this.adaptee = adaptee;
	}
	public void run(){
		adaptee.run();
	}
}
