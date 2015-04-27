package com.datastructures.arraysandstrings;

import java.util.HashSet;
import java.util.Set;

public class StringUniqueChars {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "abdee";
		System.out.println(hasUniqueChars(str));
		System.out.println(hasUniqueCharsWithoutAdditinalDS(str));
		System.out.println(uniqueUsingChecker(str));

	}
	
	private static boolean hasUniqueChars(String str){
		char[] charArray = str.toCharArray();
		Set charSet = new HashSet();
		for( char  chr : charArray){
			if(charSet.contains(chr)){
				return false;
			}else{
				charSet.add(chr);
			}
		}
		return true;
	}
	
	private static boolean hasUniqueCharsWithoutAdditinalDS(String str){
		for(int i =0 ;i<str.length();i++){
			char s = str.charAt(i);
				for(int j=i+1;j<str.length();j++){
					char s1 = str.charAt(j);
					if(s==s1){
						return false;
					}else{
						continue;
					}
			}
		}
		return true;
	}
	private static boolean uniqueUsingChecker(String str){
		
		int checker = 0 ;
		for(int i =0 ;i<str.length();i++){
			int val = str.charAt(i)-'a';
			if((checker & (1 << val))>0){
				return false;
			}
			checker |= (1 << val);
		}
		
		return true;
	}

}
