import java.util.Stack;
import java.util.Scanner;
import java.lang.String;

class InfixRelational_Test {
	public static void main (String args[]) {
		InfixRelational infixR = new InfixRelational();

		String string;
		String s = "";
		Stack<String> stringstk = new Stack<String>();

		Scanner in = new Scanner(System.in);
		System.out.println("\nFormat pengetikan ekspresi dalam infix dan setiap operan/operator dipisahkan dengan spasi\ncontoh: ( 5 < 2 )\n ( ( 2 >= 3 ) < 4 )\n( 50 <= ( -20 <= 2 ) )");
		System.out.println("Enter a string (ekspresi matematika): ");
		string = in.nextLine();
		// System.out.println("You entered: " + string);

		for (int i = 0; i < string.length(); i++) {

			if (i == string.length()-1) {
				String strx = Character.toString(string.charAt(i));
				stringstk.push(strx);
			}
			else if (string.charAt(i) != ' ') {
				String strx = Character.toString(string.charAt(i));
				s = s + strx;
			} else {
				stringstk.push(s);
				s = " ";
				stringstk.push(s);
				s = "";
			}
		}

		// reverse the stack so it is in proper order
		int size1 = stringstk.size();
		Stack<String> readystack = new Stack<String>();
		for (int i = 0; i < size1; i++) {
			readystack.push(stringstk.pop());
		}

		// print isi stack
		// int a = readystack.size();
		// for (int j = 0; j < a; j++) {
		// 	System.out.println(readystack.pop());
		// }

		infixR.setStack(readystack);
		int a = infixR.evalRelational();
		System.out.println("Hasil perhitungan (0 = false; 1 = true) : " + a);
	}
}