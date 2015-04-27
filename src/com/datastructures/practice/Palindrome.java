package com.datastructures.practice;

public class Palindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ababa";
		boolean b = fastPalindrome(str);
		if (b)
			System.out.println("Yes it is palindrome");
		else
			System.out.println("No it is not a palindrome");
	}

	private static boolean isPalindrome(String str) {

		String reverseString = reverseString(str);
		int b = str.compareTo(reverseString);
		if (b == 0) {
			return true;
		}
		return false;
	}

	private static String reverseString(String str) {
		StringBuffer strBuf = new StringBuffer();
		char[] charAry = str.toCharArray();
		for (int i = charAry.length - 1; i >= 0; i--) {
			strBuf.append(charAry[i]);
		}
		return strBuf.toString();
	}

	private static boolean fastPalindrome(String str) {
		char[] charAry = str.toCharArray();
		int size = charAry.length;
		for (int i = 0; i <= size / 2; i++) {
			if (charAry[i] != (charAry[size - i - 1])) {
				return false;
			}
		}
		return true;
	}

}
