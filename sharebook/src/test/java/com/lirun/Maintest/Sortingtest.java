package com.lirun.Maintest;

import java.util.Arrays;

import javax.faces.validator.LengthValidator;

import org.junit.Test;

public class Sortingtest {
	int[] arr = { 1, 3, 4, 2, 5, 8, 6, 7, 10, 23, 0, 15 };

	// ð�� ����
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

	// ����
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

	// ����
	@Test
	public void Test11() {
		int array[] = { 10, 5, 3, 1, 7, 2, 8, 9, 11, 4 };
		System.out.println("����֮ǰ��" + Arrays.toString(array));

		quickSort2(array, 0, array.length - 1);

		System.out.println("\n����֮��" + Arrays.toString(array));
	}

	// ���� �����Ԫ��Ϊ��׼
	public void quickSort(int arr[], int _left, int _right) {
		int left = _left;
		int right = _right;
		int temp = 0;
		if (left <= right) { // �������Ԫ�����������������
			temp = arr[left]; // ������ĵ�һ��Ԫ����Ϊ��׼Ԫ��
			while (left != right) { // ���������߽���ɨ�裬ֱ��left = right

				while (right > left && arr[right] >= temp)
					right--; // ��������ɨ�裬�ҵ���һ���Ȼ�׼Ԫ��С��Ԫ��
				arr[left] = arr[right]; // �ҵ�����Ԫ��arr[right]����arr[left]����

				while (left < right && arr[left] <= temp)
					left++; // ��������ɨ�裬�ҵ���һ���Ȼ�׼Ԫ�ش��Ԫ��
				arr[right] = arr[left]; // �ҵ�����Ԫ��arr[left]����arr[right]����

			}
			arr[right] = temp; // ��׼Ԫ�ع�λ
			quickSort(arr, _left, left - 1); // �Ի�׼Ԫ����ߵ�Ԫ�ؽ��еݹ�����
			quickSort(arr, right + 1, _right); // �Ի�׼Ԫ���ұߵĽ��еݹ�����
		}
	}

	// ���� �����Ԫ��Ϊ��׼
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

	// ���� �м�Ԫ��Ϊ��׼
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

	//��ѡ������ 
	@Test
	public void Test31() {
		int[] arr = { 10, 5, 3, 1, 7, 2, 8, 9, 11, 4 };
		System.out.println(Arrays.toString(arr));
		chooseSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	// ���� ��ѡ������  �ݹ�
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
	//��ʹ�õݹ� ��ѡ������ 
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
	//�������� ����
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
