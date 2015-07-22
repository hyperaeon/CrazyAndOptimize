package com.crazy.chapter4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Gobang {

	private String[][] board;

	private static int BOARD_SIZE = 15;

	public void initBoard() {
		board = new String[BOARD_SIZE][BOARD_SIZE];
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = "+";
			}
		}
	}

	public void printBoard() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception {
		Gobang gb = new Gobang();
		gb.initBoard();
		gb.printBoard();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		while ((inputStr = br.readLine()) != null) {
			String[] posStrArr = inputStr.split(",");
			int xPos = Integer.parseInt(posStrArr[0]);
			int yPos = Integer.parseInt(posStrArr[1]);
			gb.board[yPos - 1][xPos - 1] = "¡ñ";
			gb.printBoard();
			System.out.println("ÇëÏÂÆå×Ó£¬x,y");
		}
	}
}
