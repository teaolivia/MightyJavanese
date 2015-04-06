import java.util.*;

public class Calculator {
	public static void main (String [] args) {
		String input;
		Scanner sc = new Scanner(System.in);
		
		// CommandProcessing cmd = new CommandProcessing();
		do {
			System.out.println("Enter expression or 'quit' to quit program");
			input = sc.nextLine();
			
			switch(TypeIdentifier.whatOperator(input)) {
				// arithmetic
				case 1:
				switch(TypeIdentifier.whatAffix(input)) {
					case 1: //infix
						System.out.println("Arithmetix Infix");
						Infix inx = new Infix();
						inx.setExpression(input);
						System.out.println ("Your expression evaluates to: " + inx.evalInfix());
					  break;
					case 2: //prefix
						System.out.println("Arithmetix Prefix");
						Prefix prx = new Prefix();
						prx.setExpression(input);
						prx.evalPrefix();
                		System.out.println ("Your expression evaluates to: " + prx.getResult());
					  break;
					case 3: //postfix
						System.out.println("Arithmetix Postfix");
						// -----------------------
						// TODO ARITHMETIC POSTFIX
						// -----------------------
					  break;
					default:
						System.out.println("Wrong syntax?");
				}
				break;

				// relational
				case 2:
				switch(TypeIdentifier.whatAffix(input)) {
					case 1: //infix
						System.out.println("relational Infix");
						InfixRelational inxR = new InfixRelational();
						inxR.setExpression(input);
						System.out.println ("Your expression evaluates to: " + inxR.evalRelational());
					  break;
					case 2: //prefix
						System.out.println("relational Prefix");
						// -----------------------
						// TODO RELATIONAL PREFIX
						// -----------------------
					  break;
					case 3: //postfix
						System.out.println("relational Postfix");
						// -----------------------
						// TODO RELATIONAL POSTFIX
						// -----------------------
					  break;
					default:
						System.out.println("Wrong syntax?");
				}
				break;

				// logic
				case 3:
				switch(TypeIdentifier.whatAffix(input)) {
					case 1: //infix
						System.out.println("logic Infix");
						LogicCalculateInfix lgc = new LogicCalculateInfix();
						lgc.setExpression(input);
						System.out.println ("Your expression evaluates to: " + lgc.parsen());
					  break;
					case 2: //prefix
						System.out.println("logic Prefix");
						// -----------------------
						// TODO LOGIC PREFIX
						// -----------------------
					  break;
					case 3: //postfix
						System.out.println("logic Postfix");
						// -----------------------
						// TODO LOGIC POSTFIX
						// -----------------------
					  break;
					default:
						System.out.println("Wrong syntax?");
				}
				break;
			} // main switch
		} while (!input.equalsIgnoreCase("quit"));
	} // main
}