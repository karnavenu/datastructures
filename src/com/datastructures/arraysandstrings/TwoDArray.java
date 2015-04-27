package com.datastructures.arraysandstrings;

import java.util.Arrays;

public class TwoDArray {
	private static int[][] board;

	public static void main(String[] args) {
		board = new int[8][];
		for (int i = 0; i < 8; i++) {
			board[i] = new int[8];
			System.out.println(board[i]);
		}
		System.out.println(board[7][7]);
		System.out.println(board[7]);
	}

}
