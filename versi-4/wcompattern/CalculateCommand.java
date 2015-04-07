package wcompattern;
import java.io.Console; 
import java.lang.String;
import java.util.Stack;

import lib.LogicCalculateInfix;
import lib.PrefixRelational;
import lib.LogicCalculate;
import lib.Infix;
import lib.Prefix;
public class CalculateCommand implements Command {
	private Calculator calculator;
	
	public CalculateCommand(Calculator calculator){
		this.calculator= calculator; 
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		calculator.Calculate();
	}

}
