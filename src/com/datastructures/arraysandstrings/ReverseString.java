package com.datastructures.arraysandstrings;

import java.util.HashSet;
import java.util.Set;

public class ReverseString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "abcrdee";
		String reverseString = reverseString(str);
		System.out.println(reverseString);
		String inPlaceReverse =  inPlaceReverse(str);
		System.out.println(inPlaceReverse);

	}

	private static String reverseString(String str) {
	
		 String reversedString = "";
	        for(int i=str.length(); i>0; i--) {
	            reversedString += str.charAt(i-1);
	        }   

	        return reversedString;
		
	}
	
	private static String inPlaceReverse(String str){
		int len=str.length();
		char []c=new char[len];
		for(int j=len-1,i=0;j>=i ;j--,i++){
			char temp = str.charAt(j);
			c[j]=str.charAt(i);
		    c[i]=temp;
		  
		}
		str=String.copyValueOf(c);
		System.out.println(str);
		return str;
	}

}
