package com.lirun.decoration;

import org.junit.Test;

public class Maintest {

	@Test
	public void Test(){
		Wrappers wrapper = new Coffee(new Milke());
		System.out.println(wrapper.cost());
	}
}
