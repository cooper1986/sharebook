package com.lirun.Maintest;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.record.aggregates.DataValidityTable;
import org.apache.poi.hssf.record.formula.functions.T;
import org.junit.Test;

import com.lirun.sharebook.vo.Students;

public class Maintest implements Person{

	@Test
	public void Test() throws InstantiationException, IllegalAccessException{
		System.out.println(Person.class.isAssignableFrom(Man.class));
		System.out.println(Man.class.newInstance() instanceof Person);
		List<Man> list = new ArrayList<Man>();
		list.add(new Man(1,"li",2));
		list.add(new Man(2,"zhao",2));
		list.add(new Man(3,"wang",2));
		list.add(new Man(4,"jiang",2));
		for(int i = 0 ;i<list.size();i++){
			for(Field field:list.get(i).getClass().getDeclaredFields()){
				field.setAccessible(true);
				System.out.println(field.getName()+"------------"+field.get(list.get(i)));
			}
		}
	}

	@Override
	public void run() {
	}
}
