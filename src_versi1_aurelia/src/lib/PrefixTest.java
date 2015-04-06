package lib;
import java.io.*;
import java.util.*;
import java.util.regex.*;


public class PrefixTest {
	public static void main (String [] args) {
        Prefix pc = new Prefix();
        Scanner kb = new Scanner (System.in);
        String input;
        do {
            System.out.print ("Enter a prefix expression (or Q to quit): ");
            input = kb.nextLine();
            if (input.equalsIgnoreCase("q"))
                System.out.println ("The real answer is 42!");
            else {
                pc.setExpression(input);
                pc.evalPrefix();
                System.out.println ("Your expression evaluates to: " +
                                        pc.getResult());
            }
        } while (!input.equalsIgnoreCase("q"));
    }
}
