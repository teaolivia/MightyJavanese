package lib;

import java.io.*;
import java.util.Stack;
import java.lang.String;
import java.lang.Integer;
import java.lang.Boolean; 
import java.lang.Character;

import api.LogicCalculator;


public class LogicCalculate {
	private String expression; 
	private static final String operators = "\\AND|\\OR |\\XOR";
	private static final String operands= "\\true|\\ false";
	private Stack<String> original;
	public LogicCalculate(){}
	
	public boolean isInfix(){
		if (original.isEmpty()){
			System.out.println("No Expression"); 
		}
		if(original.peek() == "AND" || original.peek() == "OR" || original.peek() == "XOR"){
			return true;
		}
		return true;
	}
	
	public void setStack(Stack<String> stack) {
		original = stack;
	}
	
	public Stack<String> getStack() {
		// TODO Auto-generated method stub
		return original;
	}
	
	public void evalPrefix () {
        if(expression.length() == 0)
            throw new IllegalArgumentException("Expression is null");
        String expArray [] = expression.split("\\s");
        //create an array by splitting the String on whitespace
        for(int x = (expArray.length - 1); x >= 0; x--) {
            //working from the end of the array forward
            if (expArray[x].matches(operands)) {
                original.push(operands);
                //if the value at expArray[x] is a double, push it
            }
            if(expArray[x].matches(operators)) {
                calculate(expArray[x]);
                //if the value at expArray[x] is an operator, calculate
            }
        }//end for loop
    }

	
	public void calculate(String n) {
		// TODO Auto-generated method stub
		if (original.size() < 2)
            throw new IllegalArgumentException("Input expression: " + 
                                        expression + " invalid");
        String op1 = original.pop();//top of stack is really back of expression
        String op2 = original.pop();
        String op = original.get(0);//operator
        String result = "false";
        switch (op) {
            case "AND":
            	if (op1 == "true"  && op2 == "true"){ result = "true";}
            	if (op1 == "true"  && op2 == "false"){ result = "false";}
            	if (op1 == "false"  && op2 == "true"){ result = "false";}
            	if (op1 == "false"  && op2 == "false"){ result = "false";}
            	original.push(result);
              break;
            case "OR":
            	if (op1 == "true"  || op2 == "true"){ result = "true";}
            	if (op1 == "true"  || op2 == "false"){ result = "true";}
            	if (op1 == "false"  || op2 == "true"){ result = "true";}
            	if (op1 == "false"  || op2 == "false"){ result = "false";}
            	original.push(result);
              break;
            case "XOR":
            	if (op1 == "true"  ^ op2 == "true"){ result = "false";}
            	if (op1 == "true"  ^ op2 == "false"){ result = "false";}
            	if (op1 == "false"  ^ op2 == "true"){ result = "false";}
            	if (op1 == "false" 	^ op2 == "false"){ result = "false";}
            	original.push(result);
              break;
            default:
                System.out.println("What is this? " + op);
        }
	}

	 public String getResult() {
	        if (original.size() > 1 || original.isEmpty())
	            throw new IllegalArgumentException("Input expression: " + 
	                                        expression + " invalid");
	        return original.pop();
	    }
	
	public void test() {
		// TODO Auto-generated method stub
		int a = original.size();
		for (int i =0; i < a; i++) {
			System.out.println(original.pop());
	}
	}
}