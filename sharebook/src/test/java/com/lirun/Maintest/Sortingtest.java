package com.lirun.Maintest;

import java.util.Arrays;

import javax.faces.validator.LengthValidator;

import org.junit.Test;

public class Sortingtest {
	int[] arr = { 1, 3, 4, 2, 5, 8, 6, 7, 10, 23, 0, 15 };

	// 冒泡 正序
	@Test
	public void TEST01() {
		int param;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					param = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = param;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	// 倒序
	@Test
	public void TEST02() {
		int param;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = arr.length - 1; j > i; j--) {
				if (arr[j] > arr[j - 1]) {
					param = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = param;
				}
			}

		}
		System.out.println(Arrays.toString(arr));
	}

	// 快排
	@Test
	public void Test11() {
		int array[] = { 10, 5, 3, 1, 7, 2, 8, 9, 11, 4 };
		System.out.println("排序之前：" + Arrays.toString(array));

		quickSort2(array, 0, array.length - 1);

		System.out.println("\n排序之后：" + Arrays.toString(array));
	}

	// 正序 最左边元素为基准
	public void quickSort(int arr[], int _left, int _right) {
		int left = _left;
		int right = _right;
		int temp = 0;
		if (left <= right) { // 待排序的元素至少有两个的情况
			temp = arr[left]; // 待排序的第一个元素作为基准元素
			while (left != right) { // 从左右两边交替扫描，直到left = right

				while (right > left && arr[right] >= temp)
					right--; // 从右往左扫描，找到第一个比基准元素小的元素
				arr[left] = arr[right]; // 找到这种元素arr[right]后与arr[left]交换

				while (left < right && arr[left] <= temp)
					left++; // 从左往右扫描，找到第一个比基准元素大的元素
				arr[right] = arr[left]; // 找到这种元素arr[left]后，与arr[right]交换

			}
			arr[right] = temp; // 基准元素归位
			quickSort(arr, _left, left - 1); // 对基准元素左边的元素进行递归排序
			quickSort(arr, right + 1, _right); // 对基准元素右边的进行递归排序
		}
	}

	// 倒序 最左边元素为基准
	public void quickSort1(int[] arr, int _left, int _right) {
		int param = 0;
		int left = _left;
		int right = _right;
		if (left < right) {
			param = arr[_left];
			while (left != right) {
				while (left < right && arr[right] <= param)
					right--;
				arr[left] = arr[right];
				while (left < right && arr[left] >= param)
					left++;
				arr[right] = arr[left];
			}
			arr[left] = param;
			quickSort1(arr, _left, left - 1);
			quickSort1(arr, right + 1, _right);
		}

	}

	// 正序 中间元素为基准
	public void quickSort2(int[] arr, int _left, int _right) {
		int left = _left;
		int right = _right;
		int param = arr[(_left + _right) / 2];
		if (left < right) {
			while (left != right) {
				while (right > left && arr[right] > param)
					right--;
				while (left < right && arr[left] < param)
					left++;
				if (arr[left] > arr[right]) {
					int i = arr[left];
					arr[left] = arr[right];
					arr[right] = i;
				}
			}
			quickSort2(arr, _left, right - 1);
			quickSort2(arr, right + 1, _right);
		}

	}

	//简单选择排序 
	@Test
	public void Test31() {
		int[] arr = { 10, 5, 3, 1, 7, 2, 8, 9, 11, 4 };
		System.out.println(Arrays.toString(arr));
		chooseSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	// 正序 简单选择排序  递归
	public void chooseSort(int[] arr,int start){
		if(start<arr.length){
			int temp = arr[start];
			int index  = start;
			for(int i = start;i<arr.length;i++){
				if(temp>arr[i]){
					temp = arr[i];
					index = i;
				}
			}
			arr[index] = arr[start];
			arr[start] = temp;
			chooseSort(arr,++start);
		}
		
	}
	//不使用递归 简单选择排序 
	public void chooseSort(int[] arr){
		int param = 0;
		for(int i = 0;i<arr.length-1;i++){
			int index = i;
			for(int j = i+1;j<arr.length;j++){
				if(arr[index]>arr[j]){
					index = j;
				}
			}
			param = arr[index];
			arr[index] = arr[i];
			arr[i] = param;
		}
	}
	//插入排序 正序
	@Test
	public void Test41(){
		int[] arr = { 10, 5, 3, 1, 7, 2, 8, 9, 11, 4 };
		System.out.println(Arrays.toString(arr));
		insertion_sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public void insertSort(int[] arr){
		for(int i = 0;i<arr.length;i++){
			for(int j = i;j<arr.length;j++){
				if(arr[i]>arr[j]){
					int param = arr[i];
					arr[i] = arr[j];
					arr[j] = param;
				}
			}
			System.out.println(Arrays.toString(arr));
		}
	}
	 public void insertion_sort(int[] arr)
     {
         for (int i = 1; i < arr.length; i++)
         {
             if (arr[i - 1] > arr[i])
             {
                 int temp = arr[i];
                 int j = i;
                 while (j > 0 && arr[j - 1] > temp)
                 {
                	 arr[j] = arr[j - 1];
                     j--;
                 }
                 arr[j] = temp;
             }
             System.out.println(Arrays.toString(arr));
         }
     }
	
}
