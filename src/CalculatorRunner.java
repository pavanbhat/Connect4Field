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
public class CalculatorRunner {

//	CalculatorModel model = new CalculatorModel();
//	CalculatorView view = new CalculatorView();
	

		/**
	     * Main program
	     * How to execute:
	     * java Calculator 1 + 2 "*" 3
	     * Note: Operator * needs to be specified as "*" (with double quotes)
	     *
	     * @param args
	     */
	    public static void main( String[] args )
	    {
	    	CalculatorController calc = new CalculatorController();
	    	calc.start();
	        
	    }


}
