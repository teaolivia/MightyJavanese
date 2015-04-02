import java.util.ArrayList;
import java.util.Stack;
import java.util.*;
import java.io.*;
import java.lang.exception;

public class OperationPostfix (string Ekspresi)
{	/*
	private static int Precedence(String Operation)
	{
		switch (Operation.charAt(0))
		{
			case '(':
			case ')':
				return 4;
			case '^':
				return 3;
			case '/':
			case '*':
			case '%':
				return 2;
			case '+':
			case '-':
				return 1;
			default:
				
				System.err.println("Invalid operation.");
				return -1;
		}
	}
	
	private static GetOperation(int i)
	{
		string.Expression
		switch(i)
		{
			case 0:
			return GetOperation(int i);
			case 1:
			return GetOperation(int i);
			case 2:
			return GetOperation(int i);
			case 3:
			return GetOperation(int i);

		}
	}
	public double GetValue(int i)
	{
                switch(this.Operation)
                {
                    case Equals:
                        break;
                    case Power:
                        this.value
                        break;
                    case 
                }
	}

	public String GetPostfixExpression()
	{
		return this.Root.GetPostfixExpression();
	}
	*/
	private boolean isOperator(char character) { // operator checker
		boolean operator;					// operator boolean

		switch (character) {					// switch statement testing operator
			case '+':					
			case '-':
			case '*':
			case '/':
				operator = true;			// true jika token adalah operator
				break;					// end case statement

			default:					// else
				operator = false;			// false jika token bukan operator
				break;					// end case
		}							// end of switch

		return operator;					// return operator
	}

	public Parser(String input)
	{
		StringTokenizer tokens; // kumpulan token-token yang merupakan satu ekspresi
		String token; // token yang merupakan elemen stack dalam satuan string
		Integer intWrapper; // integer wrapper yang akan diubah
		char operator; // operator
		int stackSize; // ukuran stack yang akan dimasukkan token
		int op1, op2; // operan yang akan dimasukkan dalam ekspresi
		int element; // elemen yang akan dimasukkan ke dalam stack

		tokens = new StringTokenizer(this.string); // konversi string menjadi token
		stackSize = tokens.countTokens(); // stackSize menjadi ukuran token
		this.stack = new Stack<stackSize>; // membuat stack berukuran stacksize 

		while (tokens.haveMoreTokens))
		{
			token = tokens.nextToken(); // memasukka jumlah token selanjutnya
			operator = token.charAt(0); // inisiasi masukkan token
 
 			if (this.isOperator(operator))	// isOperator = TRUE
 			{
 				op2 = stack.pop();
 				op1 = stack.pop();
 				this.compute(op1,op2,operator);	// menghitung op1 dan op2
 				stack.push(this.intermediateResult); // memasukkan intermediateResult ke dalam stack
 			} else
 				{
 					intWrapper = new Integer(token); // membuat instance Integer dari String token
 					element = intWrapper.intValue(); // mendapatkan primitif dari intWrapper
 					stack.push(element); // push element ke dalam stack
 				}
		}
/*
		tanpa package StringTokenizer

		private final Stack<Expression> stack = new Stack<>();
		Scanner tokens = new Scanner(expression);
		while (tokens.hasNext())
		{
			parse(tokens.next());
		}
		if (stack.size() != 1)
		{
			throw new InvalidExpressionException("Input tidak lengkap");
		}
		return stack.pop();
*/

	}
// main untuk menjalankan operator
	public static void Main(String []args)
	{
		try 
		{
			BufferedReader input = new BufferedReader();
			String string;

			while ((string = input.readline()) != null)
			{

			}

		}
	}
}