/**
 * Lab 6: Connect4. This program is a 2 player game which can be played between
 * 2 human players or between a human and a computer
 *
 * @author Pavan Prabhakar Bhat (pxb8715@rit.edu)
 */

/**
 * 
 * These methods in the interface have been implemented using the Connect4Field class
 *
 */
public interface Connect4FieldInterface {
	public boolean checkIfPiecedCanBeDroppedIn(int column);
	public void dropPieces(int column, char gamePiece);
	boolean didLastMoveWin();
	public boolean isItaDraw();
	public String toString();
}