package lib;

import java.util.Stack;

public class LogicCalculateInfix {
	private String expression; 
	private Stack<String> original;
	public LogicCalculateInfix(){}
	
	public boolean isInfix(){
		return true; 
		
	}
	
	public void setExpression(String expression) {
		String expArray [] = expression.split("\\s");
		for(int i = (expArray.length - 1); i >= 0; i--) {
			if (i != 0) {
				original.push(expArray[i]);
				original.push(" ");
			} else {
				original.push(expArray[i]);
			}
        }
	}
	
	public String parsen() {
		// TODO Auto-generated method stub
		Stack<String> stackop = new Stack<String>();  
		Stack<String> angka = new Stack<String>();
		String result = "true";
		stackop.push("1");
		angka.push("-999");

		while (!stackop.empty() && !angka.empty()) {
			// IMPORTANT -------- IF ORDER MATTERS

			// if stack original habis
			if (original.empty()) {
				if (stackop.peek() != "l" && angka.peek() != "-555") { // masih ada hitungan
					String opa2 = angka.pop();
					String opa1 = angka.pop();
					String opr = stackop.pop();
					angka.push(calculate(opa1, opa2, opr));

					result = angka.pop();
					stackop.pop();
				} else if (stackop.size() == 1 && angka.size() == 2) {
					result = angka.pop();
					angka.pop();
					stackop.pop();
				}
				else {
					return "an Expression exists";
				}
			}

			// if whitespace
			else if (original.peek() == " " ) {
				original.pop();
			}

			// if char == angka
			else if (original.peek() != "AND" && original.peek() != "OR" && original.peek() != "XOR") {
				String c = original.pop();
				while (original.peek() != " ") {
					String d = original.pop();
					c = c + d;
				}

				angka.push(c);

			} 

			else if (original.peek() == "AND" || original.peek() == "OR" || original.peek() == "XOR") {
					
					Stack<Character> temp = (Stack<Character>)original.clone();

					if (original.peek() == "(") {
						stackop.push(original.pop());
					}
						
					else if (original.peek() == ")") {
						original.pop();
						String opa2 = angka.pop();
						String opa1 = angka.pop();
						String opr = stackop.pop();
						angka.push(calculate(opa1,opa2,opr));
						if (stackop.peek() == "(") {
							stackop.pop();
						}
					}
					else {
						stackop.push(original.pop());
					}
			}

			else {
				return "false";
			}
		}
		return result;
	}


	
	public String calculate(String op1, String op2, String op) {
		// TODO Auto-generated method stubs
		String result = "true";
        switch (op) {
            case "AND":
            	if (op1 == "1"  && op2 == "1"){ result = "true";}
            	if (op1 == "1"  && op2 == "0"){ result = "false";}
            	if (op1 == "0"  && op2 == "1"){ result = "false";}
            	if (op1 == "0"  && op2 == "0"){ result = "false";}
            	original.push(result);
              break;
            case "OR":
            	if (op1 == "1"  || op2 == "1"){ result = "true";}
            	if (op1 == "1"  || op2 == "0"){ result = "true";}
            	if (op1 == "0"  || op2 == "1"){ result = "true";}
            	if (op1 == "0"  || op2 == "0"){ result = "false";}
            	original.push(result);
              break;
            case "XOR":
            	if (op1 == "1"  ^ op2 == "1"){ result = "false";}
            	if (op1 == "1"  ^ op2 == "0"){ result = "false";}
            	if (op1 == "0"  ^ op2 == "1"){ result = "false";}
            	if (op1 == "0" 	^ op2 == "0"){ result = "false";}
            	original.push(result);
              break;
            default:
                System.out.println("What is this? " + op);
        }
		return result;
	}
}
