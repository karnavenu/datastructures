package com.datastructures.practice;

public class SortSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void sortSubArray(int array[]) {

		int max,min;
		int size = array.length;
		int i = 0;
		int j = size-1;
		for (i = 0; i < size - 1; i++) {
			if (array[i] > array[i + 1]) {
				break;
			}
		}

		if (i == size - 1) {
			System.out.println("The complete array is sorted");
			return;
		}
		
		for (j = size-1; j>0;j--) {
			if (array[j] < array[j - 1]) {
				break;
			}
		}
		max = array[i];
		min = array[i];
		int k;
		for(k = i + 1; i <= j; k++)
		  {
		    if(arr[i] > max)
		      max = arr[i];
		    if(arr[i] < min)
		      min = arr[i];
		  }

	}
}
