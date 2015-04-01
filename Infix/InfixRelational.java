import java.util.Stack;
import java.lang.String;
import java.lang.Integer;

class InfixRelational {
	
	private Stack<String> original;
	
	public InfixRelational() {}

	public void setStack(Stack<String> stack) {
		original = stack;
	}

	public Stack<String> getStack() {
		return original;
	}

	public int evalRelational() {
		Stack<String> stackop = new Stack<String>();  
		Stack<Integer> angka = new Stack<Integer>();
		String peek = "";
		int result = 0;
		stackop.push("l");
		angka.push(-999);

		while (!stackop.empty() && !angka.empty()) {
			// IMPORTANT -------- IF ORDER MATTERS
			if (!original.empty()) { peek = original.peek(); }
			String stackopPeek = stackop.peek(); 

			// if stack original habis
			if (original.empty()) {
				String peekOp = stackop.peek();

				if (!peekOp.equals("l") && angka.peek() != -999) { // masih ada hitungan
					int opa2 = angka.pop();
					int opa1 = angka.pop();
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
					return -999;
				}
			}

			// if whitespace
			else if (peek.equals(" ")) {
				original.pop();
			}

			// if char == angka
			else if (!peek.equals("<") && !peek.equals("<=") && !peek.equals(">") && !peek.equals(">=") && !peek.equals("(") && !peek.equals(")")) {
				String str = original.pop();
				int n = Integer.parseInt(str);
				angka.push(n);

			} 

			else if (peek.equals("<") || peek.equals("<=") || peek.equals(">") || peek.equals(">=") || peek.equals("(") || peek.equals(")")) {
				if (peek.equals("(")) {
					stackop.push(original.pop());
				}
				else if (peek.equals(")")) {
					original.pop();
					int opa2 = angka.pop();
					int opa1 = angka.pop();
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

	public int calculate(int opa1, int opa2, String opr) {
		Boolean tempResult;
		switch(opr) {
			case ">":
				tempResult = opa1>opa2;
				if (tempResult == true) { return 1; }
				else { return 0; }

			case "<":
				tempResult = opa1<opa2;
				if (tempResult == true) { return 1; }
				else { return 0; }

			case "<=":
				tempResult = opa1<=opa2;
				if (tempResult == true) { return 1; }
				else { return 0; }

			case ">=":
				tempResult = opa1>=opa2;
				if (tempResult == true) { return 1; }
				else { return 0; }

			default:
				System.out.println("wrong syntax");
				return 0;
		}
	}
}