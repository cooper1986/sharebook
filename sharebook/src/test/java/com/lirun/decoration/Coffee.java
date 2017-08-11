package com.lirun.decoration;

public class Coffee implements Wrappers{

	private Decorations decorations;
	
	public Coffee(Decorations decorations){
		this.decorations = decorations;
	}
	public double cost() {
		// TODO Auto-generated method stub
		return decorations.cost()+10.0;
	}

}
