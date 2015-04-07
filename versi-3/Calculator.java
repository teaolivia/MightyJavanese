package api;
import java.io.*;
import java.util.*;
import java.util.Scanner;

import lib.Prefix;
import lib.Infix; 
import lib.LogicCalculate;
import lib.PrefixRelational;
import lib.LogicCalculateInfix;

/*Main Program for Mighty Calculator version 3:
 	Program will recieve an input from user. 
 	Types of inputs and outputs: 
 	a. <expression> >> calculation result of  inputed expression 
 	b. ShowMem<n>	>> "Proses ShowMem <n>
 	c. ShowAll		>> "Proses ShowMem All"
 	d. Undo<n>		>> "Proses Undo <n>
 	e. Redo<n>		>> "Proses Redo <n>
 	f. Save			>> "Proses Save"
 * 
 */
public class Calculator {
	public static void main (String[]args){
		Prefix pc = new Prefix();
		Infix ic = new Infix();
		LogicCalculate pr = new LogicCalculate();
		PrefixRelational prl = new PrefixRelational();
		LogicCalculateInfix inl = new LogicCalculateInfix();
		Scanner kb = new Scanner (System.in);
		String input = " ";
		
		do{
			System.out.println("Mighty Calculator by OneMore");
			System.out.println("Silahkan masukkan Ekspresi/ Command:");
			input = kb.next();
			if (input.matches("(.*)ShowMem(.*)")){
				String n = input.substring(input.length()-1);
				System.out.println("Proses ShowMem"+" "+n);
			}
			if (input.matches("(.*)ShowAll(.*)")){
				System.out.println("Proses ShowMem All");
			}
			if (input.matches("(.*)Save(.*)")){
				System.out.println("Proses Save");
			}
			if (input.matches("(.*)Redo(.*)")){
				String n = input.substring(input.length()-1);
				System.out.println("Proses Redo"+" "+n);
			}
			if (input.matches("(.*)Undo(.*)")){
				String n = input.substring(input.length()-1);
				System.out.println("Proses Undo"+" "+n);
			}
		}while (!input.equalsIgnoreCase("q"));
	}
}
