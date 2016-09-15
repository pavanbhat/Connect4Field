/**
 * Lab 6: Connect4. This program is a 2 player game which can be played between
 * 2 human players or between a human and a computer
 *
 * @author Pavan Prabhakar Bhat (pxb8715@rit.edu)
 */

import java.util.Scanner;

public class Connect4FieldView {

	char gamePiece;
	String name;
	static char[][] board = new char[9][25];
	
	public static char[][] getBoard() {
		return board;
	}

	public static void setBoard(char[][] board) {
		Connect4FieldView.board = board;
	}

	public Connect4FieldView() {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < 9; i++){
			for (int k = 0; k < 25; k++) {
				board[i][k] = ' ';
			}
		}
		for (int i = 0; i < 9; i++){
			for (int k = 0; k < i; k++) {
				System.out.print(board[i][k]);
			}
		for (int j = i; j < 25 - i; j++) {
			board[i][j] = 'o';
			System.out.print(board[i][j]);
		}
		
		System.out.println();
		}
		
	}

	
	
	
		// gets the gamePiece for the respective player
		public char getGamePiece() {
			// System.out.print("Please enter your choice of game piece: ");
			setGamePiece();
			return this.gamePiece;

		}
	
		// sets the gamePiece for the respective player
		public void setGamePiece() {
			Scanner input = new Scanner(System.in);
			char in = input.next().charAt(0);
			this.gamePiece = in;
		}

		
		public void setName() {
			// System.out.print("Enter the name of the Player: ");
			Scanner input = new Scanner(System.in);
			String in = input.next();
			this.name = in;
		}
		
		public String getName() {
//			System.out.print("Enter the name of the Player: ");
			setName();
			return this.name;

		}
	
	

}
