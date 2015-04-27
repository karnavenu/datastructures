package com.datastructures.arraysandstrings;

import java.util.Stack;

public class ArrayTransportation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3,4,5,6};
		transposeRec(a, a.length,3);
		arrange(a,2,2);
	}
	
	private static void transpose(int[] arr,int index,int n){
		Stack<Integer> stack  = new Stack<Integer>();
		
		while(index-n>=0){
			stack.push(arr[index]);
			stack.push(arr[index-n]);
			index--;
			
		}
		
		for(int i =0;i<arr.length; i++){
			arr[i] = stack.pop();
		}
		
		System.out.println(arr.toString());
	}
	
	private static void transposeRec(int[] arr,int index,int n){
		
		if(index-n==0){
			arr[0] = arr[index-n];
			arr[1] = arr[index];
			return;
		}
		
		transposeRec(arr,index-1,n);
		
		arr[index-n+1] = arr[index-1];
		arr[index-n] = arr[index-n+1];
		
		
		
		System.out.println(arr.toString());
	}
	
	 static void arrange(int arr[], int n, int i)
	 {

	 if(i == 1)
	 {
	 arr[1] = arr[n];
	 arr[2] = arr[n <<1];
	 return;
	 }
	 int a = arr[i - 1];
	 int b = arr[n + i - 1];

	 arrange(arr, n, i - 1);

	 int x = 3 * (i - 1);
	 arr[x] = a;
	 arr[x + 1] = b;
	 }

}
