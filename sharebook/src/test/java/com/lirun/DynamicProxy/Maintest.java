package com.lirun.DynamicProxy;

import java.lang.reflect.Proxy;

import org.junit.Test;

import com.lirun.Maintest.Man;

public class Maintest {

	@Test
	public void Test(){
		Man man = new Man();
		DynamicProxy proxy = new DynamicProxy(man);
		Itarget instance = (Itarget)Proxy.newProxyInstance(man.getClass().getClassLoader(),man.getClass().getInterfaces(), proxy);
		instance.run();
	}
}
