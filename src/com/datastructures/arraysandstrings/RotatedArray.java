package com.datastructures.arraysandstrings;

public class RotatedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };
		int x = 1;
		System.out.println(search(a, x));

	}

	public static int doSearch(int[] a, int low, int high, int x) {

		while (low <= high) {
			int mid = (low + high) / 2;
			if (x == a[mid]) {
				return mid;
			} else if (a[low] <= a[mid]) {
				if (x > a[mid]) {
					low = mid + 1;
				} else if (x >= a[low]) {
					high = mid - 1;
				}else{
					low = mid+1;
				}
			}else if(x<a[mid]){
					high = mid-1;
			}else if(x<=a[high]){
				low = mid+1;
			}else{
				high = mid-1;
			}
			
		}

		return -1;

	}

	public static int search(int[] a, int x) {
		return doSearch(a, 0, a.length - 1, x);
	}

}
