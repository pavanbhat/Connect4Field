/**
 * Lab 6: Connect4. This program is a 2 player game which can be played between
 * 2 human players or between a human and a computer
 *
 * @author Pavan Prabhakar Bhat (pxb8715@rit.edu)
 */

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Connect4FieldModel implements Connect4FieldInterface {

	static int rows = 9;
	static int columns = 25;
	static int tempRow;
	static int tempColumn;
	static char currentGamePiece;
	static char checkGamePiece;
	static char[][] tempBoard = Connect4FieldController.getBoard;
	int temp = 0, temp1 = 0;

	public Connect4FieldModel() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * Helps check if there is a tie in the match
	 *
	 * @param None
	 * @return boolean returns returns a true or false value which tells us
	 *         whether the players have tied.
	 */
	public boolean isItaDraw() {
		for (int j = 0; j < columns; j++) {
			if (tempBoard[0][j] == 'o') {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Helps drop pieces on the board for the player
	 *
	 * @param column
	 *            column number of the players piece
	 * @param gamePiece
	 *            character used by a player
	 * @return None
	 */
	public void dropPieces(int column, char gamePiece) throws NoSuchElementException {
		int flag = 0;
		while (true) {

			for (int i = 0; i < rows; i++) {
				if (tempBoard[i][column] == 'o') {
					flag += 1;
				}
			}
			if (flag > 0) {
				tempRow = flag - 1;
				tempColumn = column;
				tempBoard[tempRow][tempColumn] = gamePiece;
				currentGamePiece = gamePiece;
				break;
			} else {
				System.out.println("There is no space in the column for the piece to be dropped");
				Scanner input = new Scanner(System.in);
				System.out.println("Please enter a new column number less than 25: ");
				column = Integer.parseInt(input.next());
				if (column >= 25) {
					System.out.println("Please enter a value lower than 25! Enter again: ");
					column = Integer.parseInt(input.next());
				}

			}

		}

	}
	
	
	/**
	 * Helps check if the last move of the player resulted in a win or not
	 *
	 * @param None
	 * @return boolean returns returns a true or false value which tells us
	 *         whether the last move resulted in a win or not.
	 */
	public boolean didLastMoveWin() {

		if (checkLeftRight() || checkTopBottom() || checkTopLeftBottom() || checkTopRightBottom()) {

			// System.out.println("The Player wins");
			return true;
		}

		return false;
	}
	
	/**
	 * Helps check the diagonal elements of the player on the board
	 *
	 * @param None
	 * @return boolean returns returns a true or false value which tells us
	 *         whether there are 3 diagonal elements in a row.
	 */
	public boolean checkTopLeftBottom() {
		// to find the index of the leftmost element in the diagonal
		int step = 0;
		// to check the flags in checkFlag
		boolean flag1 = false;
		boolean[] checkFlag = new boolean[9];
		for (int i = 1; i < checkFlag.length - tempRow; i++) {
			if (tempBoard[tempRow + i][tempColumn + i] != ' ') {
				step += 1;
			} else {
				break;
			}
		}

		temp = tempRow + step ;
		temp1 = tempColumn + step;
		
		
		for (int i = 1; i < temp; i++) {
			if (tempBoard[temp - i][temp1 - i] == currentGamePiece) {
				checkFlag[i-1] = true;
			} else {
				checkFlag[i-1] = false;
			}
		}

		for (int i = 0; i < checkFlag.length - 3; i++) {
			if (checkFlag[i] == true && checkFlag[i + 1] == true && checkFlag[i + 2] == true
					&& checkFlag[i + 3] == true) {

				flag1 = true;
			}
		}

		return flag1;
	}
	
	
	/**
	 * Helps check the diagonal elements of the player on the board
	 *
	 * @param None
	 * @return boolean returns returns a true or false value which tells us
	 *         whether there are 3 diagonal elements in a row.
	 */
	public boolean checkTopRightBottom() {
		// to find the index of the leftmost element in the diagonal
		int step = 0;
		// to check the flags in checkFlag
		boolean flag1 = false;
		boolean[] checkFlag = new boolean[9];

		// subtracted tempRow to come down only so many rows
		for (int i = 0; i < checkFlag.length - tempRow; i++) {
			if (tempBoard[tempRow + i][tempColumn - i] != ' ') {
				step += 1;
			} else {
				break;
			}
		}

		temp = tempRow + step;
		temp1 = tempColumn - step;

		for (int i = 1; i < temp; i++) {
			 if (tempBoard[temp - i][temp1 + i] == currentGamePiece) {
				checkFlag[i - 1] = true;
			} else {
				checkFlag[i - 1] = false;
			}
		}
		for (int i = 0; i < checkFlag.length - 3; i++) {
			if (checkFlag[i] == true && checkFlag[i + 1] == true && checkFlag[i + 2] == true
					&& checkFlag[i + 3] == true) {
				// System.out.println(checkFlag[i]);
				flag1 = true;
			}
		}

		return flag1;
	}
	
	/**
	 * Helps check the vertical elements of the player on the board
	 *
	 * @param None
	 * @return boolean returns returns a true or false value which tells us
	 *         whether there are 3 vertical elements in a row.
	 */
	public boolean checkTopBottom() {
		boolean flag = false;
		boolean[] checkFlag = new boolean[9];
		for (int i = 8; i >= 0; i--) {
			if (tempBoard[i][tempColumn] == currentGamePiece) {
				checkFlag[8 - i] = true;
			} else {
				checkFlag[8 - i] = false;
			}
		}
		for (int i = 0; i < checkFlag.length - 3; i++) {
			if (checkFlag[i] == true && checkFlag[i + 1] == true && checkFlag[i + 2] == true
					&& checkFlag[i + 3] == true) {
				// System.out.println(checkFlag[i]);
				flag = true;
			}
		}

		return flag;
	}

	/**
	 * Helps check the horizontal elements of the player on the board
	 *
	 * @param None
	 * @return boolean returns returns a true or false value which tells us
	 *         whether there are 3 horizontal elements in a row.
	 */
	public boolean checkLeftRight() {
		boolean flag = false;
		boolean[] checkFlag = new boolean[25];
		for (int i = 0; i < checkFlag.length - tempRow; i++) {

			if (tempBoard[tempRow][i] == currentGamePiece) {

				checkFlag[i] = true;
			} else {
				checkFlag[i] = false;
			}
		}
		for (int i = 0; i < checkFlag.length - 3; i++) {
			if (checkFlag[i] == true && checkFlag[i + 1] == true && checkFlag[i + 2] == true
					&& checkFlag[i + 3] == true) {
				flag = true;
			}
		}

		return flag;
	}

	/**
	 * Helps check if the pieces can be dropped on a particular column or not
	 *
	 * @param column
	 *            column of the board which is the position of the player
	 * @return boolean returns returns a true or false value which tells us
	 *         whether the pieces can be dropped in a particular column or not
	 */
	public boolean checkIfPiecedCanBeDroppedIn(int column) {
		int flag = 0;
		if (column >= 0) {
			for (int i = 0; i < rows; i++) {
				if (tempBoard[i][column] == 'o') {
					flag += 1;
				}
			}
			if (flag > 0) {
				return true;
			}
		} else {
			System.out.println("Please enter a valid column number");

		}
		return false;

	}
	
	/**
	 * Helps print the board for the user. It is an overridden method
	 *
	 * @param None
	 * @return String Draws the board on the console.
	 */
	public String toString() {
		String board1 = "";
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 25; j++) {
				board1 += tempBoard[i][j];
			}

			board1 += "\n";
		}
		return board1;
	}
	
	
	/**
	 * Helps determine the status of the board
	 *
	 * @param gamePiece1
	 *            players game piece
	 * @return boolean returns the status of the board
	 */
	public boolean[][] checkBoard(char gamePiece1) {
		boolean[][] checkFlag = new boolean[rows][columns];
		int flag = 0, pos = 0, pos1 = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (tempBoard[i][j] == gamePiece1) {
					checkFlag[i][j] = true;
				} else {
					checkFlag[i][j] = false;
				}
			}
		}

		return checkFlag;

	}

	/**
	 * Helps the computer to win the game
	 *
	 * @param gamePieces1
	 *            game piece of the player
	 * @param checkFlag
	 *            contains the status of the game
	 * @return int returns the column details of the point where the piece is to
	 *         be dropped.
	 */

	public int checkComputer(char gamePieces1, boolean[][] checkFlag) {
		// right check
		int k = 8, col = -1;
		boolean flag[] = new boolean[4];
		int[] index = new int[2];

		here1: for (int i = 8; i >= 0; i--) {
			for (int j = 0; j < 21; j++) {
				if (checkFlag[i][j] == true && checkFlag[i][j + 1] == true && checkFlag[i][j + 2] == true) {
					if (checkIfPiecedCanBeDroppedIn(j + 3) && i == k && tempBoard[i][j + 3] == 'o') {
						index[0] = i;
						index[1] = j + 3;
						col = index[1];
						break here1;
					}
				} else if (checkFlag[i][j] == true && checkFlag[i][j + 2] == true && checkFlag[i][j + 3] == true) {
					if (checkIfPiecedCanBeDroppedIn(j + 1) && i == k && tempBoard[i][j + 1] == 'o') {
						index[0] = i;
						index[1] = j + 1;
						col = index[1];
						break here1;
					}
				} else if (checkFlag[i][j] == true && checkFlag[i][j + 1] == true && checkFlag[i][j + 3] == true) {

					if (checkIfPiecedCanBeDroppedIn(j + 2) && i == k && tempBoard[i][j + 2] == 'o') {

						index[0] = i;
						index[1] = j + 2;
						col = index[1];
						break here1;
					}
				}
			}
			// decrements this counter if the row is decreased
			k -= 1;
		}

		// right ends here
		k = 8;
		// left begins here

		here2: for (int i = 8; i >= 0; i--) {
			for (int j = 24; j > 3; j--) {
				if (checkFlag[i][j] == true && checkFlag[i][j - 1] == true && checkFlag[i][j - 2] == true) {
					if (checkIfPiecedCanBeDroppedIn(j - 3) && i == k && tempBoard[i][j - 3] == 'o') {
						index[0] = i;
						index[1] = j - 3;
						col = index[1];
						break here2;
					}
				} else if (checkFlag[i][j] == true && checkFlag[i][j - 2] == true && checkFlag[i][j - 3] == true) {
					if (checkIfPiecedCanBeDroppedIn(j - 1) && i == k && tempBoard[i][j - 1] == 'o') {
						index[0] = i;
						index[1] = j - 1;
						col = index[1];
						break here2;
					}
				} else if (checkFlag[i][j] == true && checkFlag[i][j - 1] == true && checkFlag[i][j - 3] == true) {

					if (checkIfPiecedCanBeDroppedIn(j - 2) && i == k && tempBoard[i][j - 2] == 'o') {

						index[0] = i;
						index[1] = j - 2;
						col = index[1];
						break here2;
					}
				}
			}
			// decrements this counter if the row is decreased
			k -= 1;
		}
		// left ends here
		k = 25;
		// top begins here
		here3: for (int j = 0; j < 25; j++) {
			for (int i = 8; i > 5; i--) {
				if (checkFlag[i][j] == true && checkFlag[i - 1][j] == true && checkFlag[i - 2][j] == true) {

					if (tempBoard[i - 3][j] == 'o') {
						System.out.println("here");
						index[0] = i - 3;
						index[1] = j;
						col = index[1];
						break here3;
					}
				}

			}
			// decrements this counter if the row is decreased
			k -= 1;
		}

		// top ends here

		return col;
	}

	/**
	 * Helps the computer check the opponent's status and act accordingly
	 *
	 * @param checkFlag
	 *            contains the status of the game
	 * @return int returns the column details of the point where the piece is to
	 *         be dropped.
	 */
	public int checkOpponent(boolean[][] checkFlag) {
		int col = -1;
		// right check
	here0:for (int i = 8; i >= 0; i--) {
			for (int j = 0; j < 21; j++) {
				if (checkGamePiece == tempBoard[i][j] && checkGamePiece == tempBoard[i][j + 1]
						&& checkGamePiece == tempBoard[i][j + 2]) {
					col = j + 3;
					break here0;
				}
			}

		}
		// left check
	here1:for (int i = 8; i >= 0; i--) {
			for (int j = 24; j > 3; j--) {
				if (checkGamePiece == tempBoard[i][j] && checkGamePiece == tempBoard[i][j - 1]
						&& checkGamePiece == tempBoard[i][j - 2]) {
					col = j - 3;
					break here1;
				}
			}

		}
		// top check
	here2:for (int i = 8; i >= 0; i--) {
			for (int j = 0; j < 25; j++) {
				if (checkGamePiece == tempBoard[i][j] && checkGamePiece == tempBoard[i - 1][j]
						&& checkGamePiece == tempBoard[i - 2][j]) {
					col = j + 3;
					break here2;
				}
			}

		}
		// diagonal check
	here3:for (int i = 4; i < 9; i++) {
			for (int j = 0; j < 21; j++) {
				if (checkGamePiece == tempBoard[i][j] && checkGamePiece == tempBoard[i - 1][j + 1]
						&& checkGamePiece == tempBoard[i - 2][j + 2]) {
					col = j + 3;
					break here3;
				}
			}

		}
		// other diagonal check
	here4:for (int i = 4; i < 9; i++) {
			for (int j = 24; j > 3; j--) {
				if (checkGamePiece == tempBoard[i][j] && checkGamePiece == tempBoard[i - 1][j - 1]
						&& checkGamePiece == tempBoard[i - 2][j - 2]) {
					col = j - 3;
					break here4;
				}
			}

		}
		return col;

	}

	/**
	 * Helps the computer check whether there are consecutive 2 pieces on the
	 * board
	 *
	 * @param gamePieces1
	 *            contains the game piece of the player
	 * @param checkFlag
	 *            contains the status of the game
	 * @return int returns the column details of the point where the piece is to
	 *         be dropped.
	 */
	public int checkComputer2(char gamePieces1, boolean[][] checkFlag) {
		// right check
		int k = 8, col = -1;
		boolean flag[] = new boolean[4];
		int[] index = new int[2];

		here1: for (int i = 8; i >= 0; i--) {
			for (int j = 0; j < 21; j++) {
				if (checkFlag[i][j] == true && checkFlag[i][j + 1] == true) {
					if (checkIfPiecedCanBeDroppedIn(j + 2) && i == k && tempBoard[i][j + 2] == 'o') {
						index[0] = i;
						index[1] = j + 2;
						col = index[1];
						break here1;
					}
				} else if (checkFlag[i][j] == true && checkFlag[i][j + 2] == true) {
					if (checkIfPiecedCanBeDroppedIn(j + 1) && i == k && tempBoard[i][j + 1] == 'o') {
						index[0] = i;
						index[1] = j + 1;
						col = index[1];
						break here1;
					}
				}

			}
			// decrements this counter if the row is decreased
			k -= 1;
		}

		// right ends here
		k = 8;
		// left begins here

		here2: for (int i = 8; i >= 0; i--) {
			for (int j = 24; j > 3; j--) {
				if (checkFlag[i][j] == true && checkFlag[i][j - 1] == true) {
					if (checkIfPiecedCanBeDroppedIn(j - 2) && i == k && tempBoard[i][j - 2] == 'o') {
						index[0] = i;
						index[1] = j - 2;
						col = index[1];
						break here2;
					}
				} else if (checkFlag[i][j] == true && checkFlag[i][j - 2] == true) {
					if (checkIfPiecedCanBeDroppedIn(j - 1) && i == k && tempBoard[i][j - 1] == 'o') {
						index[0] = i;
						index[1] = j - 1;
						col = index[1];
						break here2;
					}
				}

			}
			// decrements this counter if the row is decreased
			k -= 1;
		}
		// left ends here
		k = 25;
		// top begins here
		here3: for (int j = 0; j < 25; j++) {
			for (int i = 8; i > 5; i--) {
				if (checkFlag[i][j] == true && checkFlag[i - 1][j] == true) {

					if (tempBoard[i - 2][j] == 'o') {
						System.out.println("here");
						index[0] = i - 2;
						index[1] = j;
						col = index[1];
						break here3;
					}
				}

			}
			// decrements this counter if the row is decreased
			k -= 1;
		}

		// top ends here

		return col;
	}

	
}
