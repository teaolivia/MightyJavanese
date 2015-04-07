import java.util.Stack;

class InfixRelational {
	
	private Stack<String> original = new Stack<String>();
	public static final String UNSIGNED_DOUBLE = "((\\d+\\.?\\d*)|(\\.\\d+))([Ee][-+]?\\d+)?.*?";
	
	public InfixRelational() {}

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

	public double evalRelational() {
		Stack<String> stackop = new Stack<String>();  
		Stack<Double> angka = new Stack<Double>();
		String peek = "";
		double result = 0.0;
		stackop.push("l");
		angka.push(-999.0);

		while (!stackop.empty() && !angka.empty()) {
			// IMPORTANT -------- IF ORDER MATTERS
			if (!original.empty()) { peek = original.peek(); }
			String stackopPeek = stackop.peek(); 

			// if stack original habis
			if (original.empty()) {
				String peekOp = stackop.peek();

				if (!peekOp.equals("l") && angka.peek() != -999.0) { // masih ada hitungan
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
					return -999.0;
				}
			}

			// if whitespace
			else if (peek.equals(" ")) {
				original.pop();
			}

			// if char == angka
			else if (TypeIdentifier.isNumber(peek) || peek.matches(UNSIGNED_DOUBLE)) {
				String str = original.pop();
				angka.push(new Double(str));

			} 

			else if (peek.equals("<") || peek.equals("<=") || peek.equals(">") || peek.equals(">=") || peek.equals("(") || peek.equals(")")) {
				if (peek.equals("(")) {
					stackop.push(original.pop());
				}
				else if (peek.equals(")")) {
					original.pop();
					double opa2 = angka.pop();
					double opa1 = angka.pop();
					String opr = stackop.pop();
					angka.push(calculate(opa1,opa2,opr));

					stackopPeek = stackop.peek(); // update value

					if (stackopPeek.equals("(")) {
						stackop.pop();
					}
				}
				else {
					stackop.push(original.pop());
				}
			}
			else {
				System.out.println("wrong syntax1");
			}
		}

		return result;
	}

	public double calculate(double opa1, double opa2, String opr) {
		boolean tempResult;
		switch(opr) {
			case ">":
				tempResult = opa1>opa2;
				if (tempResult == true) { return 1.0; }
				else { return 0.0; }

			case "<":
				tempResult = opa1<opa2;
				if (tempResult == true) { return 1.0; }
				else { return 0.0; }

			case "<=":
				tempResult = opa1<=opa2;
				if (tempResult == true) { return 1.0; }
				else { return 0.0; }

			case ">=":
				tempResult = opa1>=opa2;
				if (tempResult == true) { return 1.0; }
				else { return 0.0; }

			default:
				System.out.println("wrong syntax");
				return 0.0;
		}
	}
}