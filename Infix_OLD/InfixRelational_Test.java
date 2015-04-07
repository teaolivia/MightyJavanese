import java.util.Stack;
import java.util.Scanner;

class InfixRelational_Test {
	public static void main (String args[]) {
		InfixRelational infixR = new InfixRelational();

		String expression;
		Stack<String> strstack = new Stack<String>();

		Scanner in = new Scanner(System.in);
		System.out.println("\nFormat pengetikan ekspresi dalam infix dan setiap operan/operator dipisahkan dengan spasi\ncontoh: ( 5 < 2 )\n ( ( 2 >= 3 ) < 4 )\n( 50 <= ( -20 <= 2 ) )");
		System.out.print("Enter a string (ekspresi matematika): ");
		expression = in.nextLine();

		infixR.setStack(strstack);
		double a = infixR.evalRelational();
		System.out.println("Hasil perhitungan (0 = false; 1 = true) : " + a);
	}
}