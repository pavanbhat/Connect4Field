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

import java.util.EmptyStackException;


public class CalculatorModel {

	
	
	public CalculatorModel() {
		// TODO Auto-generated constructor stub
	}
	
	public double evaluate( String expression )
    {
        // Tokenize string expression into array of characters
        char[] tokens = expression.toCharArray();

        // Stack to hold numbers or values from input
        MyStack<Double> valueStack = new MyStack<>();

        // Stack to hold operators from input
        MyStack<Character> operatorStack = new MyStack<>();

        for ( int i = 0; i < tokens.length; i++ )
        {
            //  Skip current token, if it is a whitespace
            if ( tokens[i] == ' ' )
                continue;

            // If current token is a number, push it to stack of numbers
            if ( tokens[i] >= '0' && tokens[i] <= '9' )
            {
                StringBuilder sbuf = new StringBuilder();

                // Handle input if there are multiple digits in given number token
                while ( i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9' )
                    sbuf.append(tokens[i++]);
                valueStack.push(Double.parseDouble(sbuf.toString()));
            }

            // If current token is a starting bracket, push it to 'operatorStack'
            else if ( tokens[i] == '(' )
                operatorStack.push( tokens[i] );

            // If current token is a closing bracket, first evaluate the expression
            // inside the brackets
            else if ( tokens[i] == ')' )
            {
                while ( operatorStack.peek() != '(' )
                    valueStack.push( applyOp( operatorStack.pop(), valueStack.pop(), valueStack.pop() ) );
                operatorStack.pop();
            }

            // If current token is any of the operator
            else if ( tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == '*' || tokens[i] == '/' ||
                    tokens[i] == '%' || tokens[i] == '^')
            {
                // While top of 'operatorStack' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'operatorStack'
                // to top two elements in valueStack
                while ( !operatorStack.empty() && hasPrecedence( tokens[i], operatorStack.peek() ) )
                    valueStack.push( applyOp( operatorStack.pop(), valueStack.pop(), valueStack.pop() ) );

                // Push current token to 'operatorStack'.
                operatorStack.push( tokens[i] );
            }
        }

        // Entire expression has been parsed at this point, apply remaining
        // operatorStack to remaining values from valueStack
        while ( !operatorStack.empty() )
            valueStack.push( applyOp( operatorStack.pop(), valueStack.pop(), valueStack.pop() ) );

        // Top of 'valueStack' contains result, return it
        return valueStack.pop();
    }
	
	/**
     * Returns exponentiation ( a ^ b )
     * @param a
     * @param b
     * @return Exponentiation result of a ^ b
     */

    private double pow( double a, double b ) {
        double result = 1;

        for ( int i = 1; i <= b; i++ ) {
            result *= a;
        }

        return result;
    }
	
	
	/**
     *  Compares precedence of given two operators.
     *
     * @param   op1 First operator
     * @param   op2 Second operator
     *
     * @return      Return true if 'op2' has higher precedence as 'op1'
     */

    public static boolean hasPrecedence( char op1, char op2 )
    {
        return ( CalculatorController.getPrecedenceValue( op1 ) < CalculatorController.getPrecedenceValue( op2 )) ;
    }

    
    /**
     * Returns result of arithmetic operation.
     * Following operations are supported: '+', '-', '%', '*', '/' and '^'.
     *
     * @param   op  Operation to be performed
     * @param   b   Operand 2
     * @param   a   Operand 1
     *
     * @return      Integer result of the operation
     *
     * @exception   ArithmeticException Thrown when division by 0 is attempted in expression evaluation.
     */

    public double applyOp( char op, double b, double a ) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '%':
                if (b == 0)
                    throw new
                            ArithmeticException( "Cannot divide by zero" );
                return a % b;
            case '/':
                if (b == 0)
                    throw new
                            ArithmeticException( "Cannot divide by zero" );
                return a / b;
            case '^':
                return pow(a, b);
        }

        return 0;
    }
}
/**
 * Implementation of Stack using generic LinkedList
 * @param <T> Type of stack
 */

class MyStack<T> {

    // Private Node class
    private class Node {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node top;   // top of the stack

    public MyStack() {
        top = null;
    }

    /**
     * Push item to the top of the stack
     * @param item Item to be pushed to stack
     */

    public void push(T item) {
        top = new Node(item, top);
    }

    /**
     * Pops item from top of the stack, and decrements top of the stack
     * @return Value of top of the stack
     * @throws EmptyStackException Thrown when there are no more items to pop
     */

    public T pop() {
        if(empty()) {
            throw new EmptyStackException();
        }

        T item = top.item;
        top = top.next;

        return item;
    }

    /**
     * Gets value from top of the stack, without decrementing top of the stack
     * @return Value of top of the stack
     * @throws EmptyStackException Thrown when stack is empty
     */

    public T peek() {
        if(empty()) {
            throw new EmptyStackException();
        }

        T item = top.item;

        return item;
    }

    /**
     * Returns true if stack is empty, false otherwise
     * @return  Boolean value indicating if stack is empty
     */

    public boolean empty() {
        return top == null;
    }
}