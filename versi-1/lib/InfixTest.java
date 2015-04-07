package lib;
import java.util.Stack;
import java.util.Scanner;
import java.lang.Character;
import java.util.*;
import java.io.*;

public class InfixTest {
	public static void main (String args[]) {
		Infix infix = new Infix();

		String string;
		Stack<Character> charstack = new Stack<Character>();

		Scanner in = new Scanner(System.in);
		System.out.println("\nFormat pengetikan ekspresi dalam infix dan setiap operan/operator dipisahkan dengan spasi\ncontoh: ( 5 + 2 )\n ( ( 2 + 3 ) * 4 )\n( 50 + ( -20 * 2 ) )");
		System.out.println("Enter a string (ekspresi matematika): ");
		string = in.nextLine();
		// System.out.println("You entered: " + string);

		for (int i = string.length()-1; i>=0; i--) {
			charstack.push(string.charAt(i));
		}

		infix.setStack(charstack);
		int a = infix.parsen();
		System.out.println("Hasil perhitungan = " + a);
	}
}
