/**
 * Lab6: Calculator that evaluates the basic arithmetic operations: *, /, +, -, % and ^.
 *  Default operator precedence is as follows:
 *      Precedence(+) = 1
 *      Precedence(-) = 2
 *      Precedence(%) = 3
 *      Precedence(*) = 4
 *      Precedence(/) = 5
 *
 * @author      Pavan Prabhakar Bhat    (pxb8715@rit.edu)
 */

import java.util.Scanner;

public class CalculatorView {

	private String inputExpression;
	

	public CalculatorView() {
		// TODO Auto-generated constructor stub
	}
	
	public void setInput(){
		System.out.println("Please enter an expression: ");
		Scanner input = new Scanner(System.in);
		this.inputExpression = input.nextLine();
		
		if( inputExpression.length() == 0 ) {
            System.err.println( "Expression input not provided !" );
            System.err.println( "Usage: java Calculator <mathematical expression with tokens space separated>" );
            System.err.println( "Example: java Calculator 1 + 2 \"*\" 3" );
            input.close();
            return;
        }
		input.close();     
		
	}
	
	public String getInput(){
		return this.inputExpression;
	}

	public void printResult() {
		// TODO Auto-generated method stub
		System.out.println("The result is: "+CalculatorController.getResult());
		
	}

}
