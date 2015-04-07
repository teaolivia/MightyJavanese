import java.util.Stack;
import java.util.regex.*;

public class Infix {
	private Stack<String> original;
	public static final String CHARACTER = "\\+|\\-|\\*|\\/";  
    public static final String UNSIGNED_DOUBLE = 
        "((\\d+\\.?\\d*)|(\\.\\d+))([Ee][-+]?\\d+)?.*?";

	public Infix() {}
	
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

	public double evalInfix() {
		Stack<String> stackop = new Stack<String>();  
		Stack<Double> angka = new Stack<Double>();
		double result = 0.0;
		stackop.push("l");
		String opeek = "";
		angka.push(-99999999.0);

		while (!stackop.empty() && !angka.empty()) {
			if (!original.empty()) { opeek = original.peek(); }
			String stackopeek = stackop.peek();
			double angkapeek = angka.peek();
			// System.out.println("/"+opeek+"/");

			if (original.empty()) {
				if (!stackopeek.equals("l") && angkapeek != -99999999.0) { // masih ada hitungan
					double opa2 = angka.pop();
					double opa1 = angka.pop();
					String opr = stackop.pop();
					angka.push(calculate(opa1,opa2,opr));

					result = angka.pop();
					stackop.pop();
				} else if (stackop.size() == 1 && angka.size() == 2) {
					result = angka.pop();
					angka.pop();
					stackop.pop();
				}
				else {
					return -888.0;
				}
			}

			// if whitespace
			else if (opeek.equals(" ")) {
				original.pop();
			}

			// if string == angka
			else if (TypeIdentifier.isNumber(opeek) || opeek.matches(UNSIGNED_DOUBLE)) {
				String str = original.pop();;
				angka.push(new Double(str));
			} 

			// if string == operator
			else if (TypeIdentifier.isOperator(opeek) || opeek.equals("(") || opeek.equals(")")) {

				Stack<String> temp = (Stack<String>)original.clone();
				if (opeek.equals("(")) {
					stackop.push(original.pop());
				}

				else if (opeek.equals(")")) {
						original.pop();
						double opa2 = angka.pop();
						double opa1 = angka.pop();
						String opr = stackop.pop();
						angka.push(calculate(opa1,opa2,opr));
						stackopeek = stackop.peek();
						if (stackopeek.equals("(")) {
							stackop.pop();
					}
				}

				else {
					System.out.println("mewmew");
					stackop.push(original.pop());
				}
			} 

			else { return -999.0; }

		} // while loop
		return result;
	} // parsen

	public double calculate(double opa1, double opa2, String opr) {
		if (opr.equals("+")) { return opa1 + opa2; }
		else if (opr.equals("-")) { return opa1 - opa2; }
		else if (opr.equals("*")) { return opa1 * opa2; }
		else { return opa1 / opa2; }
	}

}