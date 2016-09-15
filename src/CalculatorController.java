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
public class CalculatorController {
	CalculatorModel model = new CalculatorModel();
	CalculatorView view = new CalculatorView();
	private static String inputExpression;
	private static double result;
	
	// Precedence operators with increasing order of precedence
    static Character[] precedence = { '-', '+', '%', '*', '/' , '^'};

	public CalculatorController() {
		// TODO Auto-generated constructor stub
		view.setInput(); 
		CalculatorController.inputExpression = view.getInput();
	}

	/**
     * Sets precedence for expression evaluations.
     *
     * @param   newPrecedence   Character array of operators, with increasing order of precedence
     */

    public static void setPrecedence( Character[] newPrecedence ) {
        if( newPrecedence == null || newPrecedence.length == 0 ) {
            return;
        }

        precedence = newPrecedence;
    }

    /**
     * Returns precedence level of the given operator.
     *
     * @param   op  Operator for which precedence level is to be found
     *
     * @return  int Value of precedence
     */
    public static int getPrecedenceValue( Character op ) {
        int value = -1;

        for ( int i = 0; i < precedence.length; i++ ) {
            if( precedence[i] == op ) {
                value = i;
                break;
            }
        }

        return value;
    }
	
	
	protected void start(){
		
		// Read expression input to be evaluated from input
        StringBuilder expr = new StringBuilder();
//        System.out.println(this.inputExpression);
        
        for ( int i = 0; i < CalculatorController.inputExpression.toCharArray().length; i++ ) {
        	if(CalculatorController.inputExpression.toCharArray()[i] >= '0' && CalculatorController.inputExpression.toCharArray()[i] <= '9'){
//        		System.out.println(this.inputExpression.toCharArray()[i]);
        		expr.append( CalculatorController.inputExpression.toCharArray()[i]);
        	}
        	else{
//        		System.out.println(" " + this.inputExpression.toCharArray()[i] + " " );
                expr.append( " " + CalculatorController.inputExpression.toCharArray()[i] + " " );
        	}
        	
        }
//        System.out.println(expr);
		
		try {
            setResult(model.evaluate( expr.toString() ) );
            view.printResult();
        } catch ( ArithmeticException ae ) {
            System.err.println( "Exception while evaluating expression : " + ae.toString() );
        }
	}
	
	public static double getResult() {
		return result;
	}

	public static void setResult(double result) {
		CalculatorController.result = result;
	}
	
	
	
}
