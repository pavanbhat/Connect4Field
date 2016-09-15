/**
 * Lab 6: Connect4. This program is a 2 player game which can be played between
 * 2 human players or between a human and a computer
 *
 * @author Pavan Prabhakar Bhat (pxb8715@rit.edu)
 */

import java.util.Scanner;

public class Connect4FieldController {
	
	Connect4FieldModel aConnect4FieldModel  = new Connect4FieldModel();
	Connect4FieldView bConnect4FieldView = new Connect4FieldView();
	public static char[][] getBoard = Connect4FieldView.getBoard();
	Player[] thePlayers = new Player[2];
	Player aPlayer = new Player();
	Player bPlayer = new Player();
	public char getGamePiece;
	public String getName;
	static char checkGamePiece;

	public Connect4FieldController(){
		
//		getGamePiece = bConnect4FieldView.getGamePiece();
//		getName = bConnect4FieldView.getName();
	}
	
	protected void start() {
		// TODO Auto-generated method stub
		init();
	}
	
	/**
	 * Helps initialize the player objects and takes input from the user names
	 * and gamePieces for use in the game
	 *
	 * @param aPlayer
	 *            Player A
	 * @param bPlayer
	 *            Player B
	 * @return None
	 */
	public void init() {

		

		System.out.println("Enter the name of Player A: ");
		String player1 = bConnect4FieldView.getName();
		
		System.out.println("Enter the game piece for Player A: ");
		char gamePiece1 = bConnect4FieldView.getGamePiece();
		
		thePlayers[0] = new Player(bConnect4FieldView, player1, gamePiece1);

		System.out.println("Whom do you want to play with ? Player(P) or Computer(C) ");
		Scanner input = new Scanner(System.in);
		String choice = input.next();
		while (true) {
			if (choice.equalsIgnoreCase("Player") || choice.equalsIgnoreCase("P")) {
				System.out.println("Enter the name of Player B: ");
				String player2 = bConnect4FieldView.getName();

				System.out.println("Enter the game piece for Player B: ");
				char gamePiece2 = bConnect4FieldView.getGamePiece();

				thePlayers[1] = new Player(bConnect4FieldView, player2, gamePiece2);
				break;
			} else if (choice.equalsIgnoreCase("Computer") || choice.equalsIgnoreCase("C")) {

				String player2 = "Danger";

				System.out.println("Enter the game piece for Computer: ");
				char gamePiece2 = bConnect4FieldView.getGamePiece();

				thePlayers[1] = new Player(bConnect4FieldView, player2, gamePiece2);
				break;
			} else {
				System.out.println("Sorry i did not understand your choice, Please enter again: ");
				input = new Scanner(System.in);
				choice = input.next();
			}
		}

		playTheGame();

	}
	

	/**
	 * Helps play and execute the game.
	 *
	 * @param None
	 * @return None
	 */

	public void playTheGame() {
		int column;

		boolean gameIsOver = false;
		do {
			for (int index = 0; index < 2; index++) {
				System.out.println(aConnect4FieldModel.toString());
				if (aConnect4FieldModel.isItaDraw()) {
					System.out.println("Draw");
					gameIsOver = true;
				} else {

					column = thePlayers[index].nextMove();
					aConnect4FieldModel.dropPieces(column, thePlayers[index].getGamePiece());
					if (aConnect4FieldModel.didLastMoveWin()) {
						gameIsOver = true;
						System.out.println(aConnect4FieldModel.toString());
						System.out.println("The winner is: " + thePlayers[index].getName());
						break;
					}
				}
			}

		} while (!gameIsOver);
	}

	
}
