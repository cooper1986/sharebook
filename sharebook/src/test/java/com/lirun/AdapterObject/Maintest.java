package com.lirun.AdapterObject;

import org.junit.Test;

public class Maintest {

	@Test
	public void Test() throws InstantiationException, IllegalAccessException{
		Itarget i = new Adapter(new Adaptee());
		i.run();
		
	}
}
