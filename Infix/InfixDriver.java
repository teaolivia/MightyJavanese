
import java.util.Scanner;

class InfixDriver {
	public static void main (String args[]) {
		Infix infix = new Infix();

		String expression;
		Scanner in = new Scanner(System.in);
		System.out.println("\nFormat pengetikan ekspresi dalam infix dan setiap operan/operator dipisahkan dengan spasi\ncontoh: ( 5 + 2 )\n ( ( 2 + 3 ) * 4 )\n( 50 + ( -20 * 2 ) )");
		System.out.println("Enter a string (ekspresi matematika): ");
		expression = in.nextLine();
		// System.out.println("You entered: " + string);

		// for (int i = string.length()-1; i>=0; i--) {
		// 	char c = string.charAt(i);
		// 	strstack.push(Character.toString(c));
		// }



		infix.setExpression(expression);
		// infix.test();
		double a = infix.evalInfix();
		System.out.println("Hasil perhitungan = " + a);
	}
}