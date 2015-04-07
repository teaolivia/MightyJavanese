package lib;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Prefix {
	private String expression; 
	private Stack<Double> nums; 
	public static final String CHARACTER = "\\+|\\-|\\*|\\/";  
    public static final String UNSIGNED_DOUBLE = 
        "((\\d+\\.?\\d*)|(\\.\\d+))([Ee][-+]?\\d+)?.*?";

    public Prefix() {
        nums = new Stack<Double>();
        expression = "";
    }
    
    /**
     * @precondition    Expression string is not null.
     * @precondition    Stack has been instantiated.
     * 
     * @postcondition   The expression has been completely evaluated.
     * 
     * @throws  IllegalArgumentException when expression is null.
     */
    public void evalPrefix () {
        if(expression.length() == 0)
            throw new IllegalArgumentException("Expression is null");
        String expArray [] = expression.split("\\s");
        //create an array by splitting the String on whitespace
        for(int x = (expArray.length - 1); x >= 0; x--) {
            //working from the end of the array forward
            if (expArray[x].matches(UNSIGNED_DOUBLE)) {
                nums.push(new Double(expArray[x]));
                //if the value at expArray[x] is a double, push it
            }
            if(expArray[x].matches(CHARACTER)) {
                calculate(expArray[x]);
                //if the value at expArray[x] is an operator, calculate
            }
        }//end for loop
    }
    
    /**
     * @precondition    Argument must be one of +, -, *, or /.
     * @precondition    The stack must conatain at least 2 doubles.
     * 
     * @param   String n    This is the operator used in calculation.
     * 
     * @postcondition   The top 2 doubles have been pulled off the top of
     *  the stack, operation based on the parameter has been calculated, and
     *  the result pushed back onto the top of the stack.
     *  
     * @throws  IllegalArgumentException when the stack size is less than 2.
     */
    public void calculate (String n) {
        if (nums.size() < 2)
            throw new IllegalArgumentException("Input expression: " + 
                                        expression + " invalid");
        double op1 = nums.pop();//top of stack is really back of expression
        double op2 = nums.pop();
        char op = n.charAt(0);//operator
        switch (op) {
            case '+':
              nums.push(op1 + op2);
              break;
            case '-':
              nums.push(op1 - op2);
              break;
            case '*':
              nums.push(op1 * op2);
              break;
            case '/':
              nums.push(op1 / op2);
              break;
            default:
                System.out.println("What is this? " + op);
        }
    }
    
    /** 
     * @precondition    The stack has one and only one element left on it.
     * 
     * @postcondition   The stack is empty.
     * 
     * @throws  IllegalArgumentException when the stack is empty or has more
     *  than one element left.
     */        
    public double getResult() {
        if (nums.size() > 1 || nums.isEmpty())
            throw new IllegalArgumentException("Input expression: " + 
                                        expression + " invalid");
        return (double)nums.pop();
    }
    
    /**
     * @param   String e    Value used to set the instance variable expression.
     * 
     * @postcondition   Instance variable expression has been set to the value
     *  of the parameter.
     */
    public void setExpression (String e) {
        expression = e;
    }
}
