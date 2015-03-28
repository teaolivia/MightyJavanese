import java.util.Stack;
import java.lang.Character;
import java.lang.Integer;
import java.lang.Boolean;

class Infix {
	
	private Stack<Character> original;

	public Infix() {}
	
	public void setStack(Stack<Character> stack) {
		// original = (Stack<Character>)stack.clone();
		original = stack;
	}

	public Stack<Character> getStack() {
		return original;
	}

	public int parsen() {
		Stack<Character> stackop = new Stack<Character>();  
		Stack<Integer> angka = new Stack<Integer>();
		int result = 0;
		stackop.push('l');
		angka.push(-999);

		while (!stackop.empty() && !angka.empty()) {
			// IMPORTANT -------- IF ORDER MATTERS

			// if stack original habis
			if (original.empty()) {
				if (stackop.peek() != 'l' && angka.peek() != -555) { // masih ada hitungan
					int opa2 = angka.pop();
					int opa1 = angka.pop();
					char opr = stackop.pop();
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
			else if (original.peek() == ' ') {
				original.pop();
			}

			// if char == angka
			else if (original.peek() != '+' && original.peek() != '-' && original.peek() != '/' && original.peek() != '*' && original.peek() != '(' && original.peek() != ')') {
				char c = original.pop();
				String str = Character.toString(c);
				while (original.peek() != ' ') {
					char d = original.pop();
					String strx = Character.toString(d);
					str = str + strx;
				}

				int n = Integer.parseInt(str);
				angka.push(n);

			} 

			else if (original.peek() == '+' || original.peek() == '-' || original.peek() == '/' || original.peek() == '*' || original.peek() == '(' || original.peek() == ')') {
					
					Stack<Character> temp = (Stack<Character>)original.clone();

					if (original.peek() == '(') {
						stackop.push(original.pop());
					}
						
					else if (original.peek() == ')') {
						original.pop();
						int opa2 = angka.pop();
						int opa1 = angka.pop();
						char opr = stackop.pop();
						angka.push(calculate(opa1,opa2,opr));
						if (stackop.peek() == '(') {
							stackop.pop();
						}
					}

					else if (original.peek() == '-') {
						temp.pop();
						// if predecessor - is angka -- berarti int minus
						if (temp.peek() != '+' && temp.peek() != '-' && temp.peek() != '/' && temp.peek() != '*' && temp.peek() != '(' && temp.peek() != ')' && temp.peek() != ' ') {
							char c = original.pop();
							String str = Character.toString(c);

							while (original.peek() != ' ') {
								char d = original.pop();
								String strx = Character.toString(d);
								str = str + strx;
							}

							int n = Integer.parseInt(str);
							angka.push(n);
						} else {
							stackop.push(original.pop());
						}
					}

					else {
						stackop.push(original.pop());
					}
			}

			else {
				return -999;
			}
		}
		return result;
	} // parsen

	public int calculate(int opa1, int opa2, char opr) {
		if (opr == '+') { return opa1 + opa2; }
		else if (opr == '-') { return opa1 - opa2; }
		else if (opr == '*') { return opa1 * opa2; }
		else { return opa1 / opa2; }
	}

	public void test() {
		int a = original.size();
		for (int i =0; i < a; i++) {
			System.out.println(original.pop());
		}
	}
}