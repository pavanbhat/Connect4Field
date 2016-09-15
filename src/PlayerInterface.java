/**
 * Lab 6: Connect4. This program is a 2 player game which can be played between
 * 2 human players or between a human and a computer
 *
 * @author Pavan Prabhakar Bhat (pxb8715@rit.edu)
 */

/**
 * 
 * These methods in the interface have been implemented using the Player class
 *
 */
public interface PlayerInterface {
	// this is how your constructor has to be
	// Player(Connect4FieldInterface theField, String name, char gamePiece)
		
		public int  nextMove();
}
