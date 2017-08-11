package com.weitalk;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.lirun.Maintest.Man;

public class MainTest {

	// for while 递归计算给定数列的总和
	@Test
	public void Test() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int total = 0;
		// for(int param :arr){
		// total += param;
		// }

		// int i = 0;
		// while(i<arr.length){
		// total += arr[i++];
		// }
		// System.arraycopy(arr, 1, arr, 0, arr.length-1);
		// arr = Arrays.copyOf(arr, arr.length-1);
		// System.out.println(Arrays.toString(arr));
		total += recursive(arr);

		System.out.println(total);
	}

	public int recursive(int[] arr) {
		if (arr.length > 1) {
			int param = arr[0];
			System.arraycopy(arr, 1, arr, 0, arr.length - 1);
			arr = Arrays.copyOf(arr, arr.length - 1);
			System.out.println(Arrays.toString(arr));
			return param + recursive(arr);
		}
		return arr[0];
	}

	// 编写一个交错合并数列A:[a,b,c] B:[1,2,3] target:[a,1,b,2,c,3]
	@Test
	public void Test1() {
		String[] arr1 = { "a", "b", "c" };
		String[] arr2 = { "1", "2", "3" };
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < arr1.length; i++) {
			list.add(arr1[i]);
			for (int j = i; j < arr2.length;) {
				list.add(arr2[j++]);
				break;
			}
		}
		System.out.println(Arrays.toString(list.toArray()));
	}

	// 计算菲波那切数列前一百位
	@Test
	public void Test2() {
		int counter = 0;
		for (int i = 1; i <= 6; i++) {
			counter += count100(i);
		}
		System.out.println(counter);
	}

	public int count100(int param) {
		if (param > 2) {
			return count100(param - 1) + count100(param - 2);
		} else if (param == 1) {
			return 0;
		} else if (param == 2) {
			return 1;
		} else {
			return -1;
		}
	}
	//编写一个能将给定非负整数列表中的数字排列成最大数字的函数 [50,2,1,9,3,46] target95021
	@Test
	public void Test3(){
		int[] arr ={50,2,1,9,3,46};
		for(int i =0;i<arr.length-1;i++){
			for(int j = 0;j<arr.length-1-i;j++){
				int param1 = arr[j]/(int) Math.pow(10, String.valueOf(arr[j]).length()-1);
				int param2 = arr[j+1]/(int) Math.pow(10, String.valueOf(arr[j+1]).length()-1);
				if( param1<param2){
					int param = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = param;
				}
			}
		}
		StringBuilder target = new StringBuilder("");
		for(int i:arr){
			target.append(i);
		}
		int finalTarget = Integer.valueOf(target.toString());
		System.out.println(finalTarget);
	}
	//编写一个在1,2...9数字之间插入+/- 或者不填 使计算总和为100 并输出所有可能
	// eg：1+2+34-5+67-8+9 =100
	@Test
	public void Test4(){
		int i=1;
		int j=2;
		System.out.println(Math.pow(10, 2));
	}
	//不借助BigDecimal 将大数据转为target
	

}
