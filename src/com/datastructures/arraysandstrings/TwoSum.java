package com.datastructures.arraysandstrings;

public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] numbers = {1,3,3,4,5,6,7};
		int target = 9;
		int[] output =twoSum(numbers,9);
		System.out.println("1st: "+output[0]+"===2nd: "+output[1]);

	}
	
	public static int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length == 0)
			return null;
	 
		int i = 0;
		int j = numbers.length - 1;
	 
		while (i < j) {
			int x = numbers[i] + numbers[j];
			if (x < target) {
				i++;
			} else if (x > target) {
				j--;
			} else {
				return new int[] { i + 1, j + 1 };
			}
		}
	 
		return null;
	}

}
