

//import statements
import java.util.*;

/**
 * Lab 6: Connect4. This program is a 2 player game which can be played between
 * 2 human players or between a human and a computer
 *
 * @author Pavan Prabhakar Bhat (pxb8715@rit.edu)
 */

public class Player implements PlayerInterface {

	char gamePiece;
	Connect4FieldView theField;
	Connect4FieldController aConnect4FieldController;
	String name;
	Random position = new Random();
	boolean[][] checkFlag = new boolean[9][25];
	

	// Default constructor
	public Player() {
		// TODO Auto-generated constructor stub
	}

	// Parameterized constructor initializes the class variables
	public Player(Connect4FieldView theField, String name, char gamePiece) {
		// TODO Auto-generated constructor stub
		this.theField = theField;
//		this.aConnect4FieldController =this.theField;
		this.name = name;
		this.gamePiece = gamePiece;

	}
	
		

	public String getName() {
		return name;
	}

	public char getGamePiece() {
		return gamePiece;
	}

	// Gets the next move of the current player
	public int  nextMove() {
		int col = -1;  
// 		if(name == "Danger"){
//			checkFlag = theField.checkBoard(this.gamePiece);
//
//				//computer checks for 3 pieces
//			while(true){
//				col = theField.checkComputer(this.gamePiece, checkFlag );
//				
//
//				//computer checks for opponent's 3 pieces
//				if(col == -1){
//					col= theField.checkOpponent(checkFlag);
//					break;
//				}
//				if(col == -1){
//					col = theField.checkComputer2(this.gamePiece, checkFlag );
//					break;
//				}
//				if(col == -1){
//					while(true){
//						col = position.nextInt(24);
//						if(theField.checkIfPiecedCanBeDroppedIn(col)){
//							break;
//						}
//					}
//				}
//			}
// 		}
//		else{
			System.out.println("Enter "+ this.name +"'s next move: ");
			Scanner input =new Scanner(System.in);
			while(true){
				col = Integer.parseInt(input.next());
				if(col <= 24){
					break;
				}
			}
			
//		}
 		
		return col;
	}
}

