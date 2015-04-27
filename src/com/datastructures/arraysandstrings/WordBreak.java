package com.datastructures.arraysandstrings;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("venu");
		dict.add("karna");
		dict.add("actiance");
		wordBreak("sdweqevenukarnaisatactiance", dict);
		System.out.println(wordBreakLeet("venukarnaactiance", dict));
		

	}

	private static void wordBreak(String str, Set<String> dict) {

		String sWord;
		for (int i = 0; i < str.length() - 1; i++) {
			for (int j = str.length(); j > i; j--) {
				sWord = checkWord(str.substring(i, j), dict);
				if (sWord != "") {
					System.out.println(sWord);
					break;
				}
			}
		}

	}

	private static String checkWord(String word, Set<String> dict) {
		if (dict.contains(word))
			return word;

		return "";

	}

	public static boolean wordBreakLeet(String s, Set<String> dict) {
		return wordBreakHelper(s, dict, 0);
	}

	public static boolean wordBreakHelper(String s, Set<String> dict, int start) {
		if (start == s.length())
			return true;

		for (String a : dict) {
			int len = a.length();
			int end = start + len;

			// end index should be <= string length
			if (end > s.length())
				continue;

			if (s.substring(start, start + len).equals(a))
				if (wordBreakHelper(s, dict, start + len))
					return true;
		}

		return false;
	}

}
