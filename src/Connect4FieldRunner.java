/**
 * Lab 6: Connect4. This program is a 2 player game which can be played between
 * 2 human players or between a human and a computer
 *
 * @author Pavan Prabhakar Bhat (pxb8715@rit.edu)
 */

public class Connect4FieldRunner {

	public Connect4FieldRunner() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Connect4FieldView aConnect4FieldView = new Connect4FieldView();
		Connect4FieldController aConnect4FieldController = new Connect4FieldController();
		aConnect4FieldController.start();
	}

}
