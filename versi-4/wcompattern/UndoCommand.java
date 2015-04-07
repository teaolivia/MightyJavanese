package wcompattern;

import java.io.Console;

public class UndoCommand implements Command {
	private Calculator calculator;
	private int a = 0; 
	
	public UndoCommand(Calculator calculator){
		this.calculator= calculator; 
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Console console = System.console();
		String s=console.readLine();
		int a = Integer.parseInt(console.readLine());
		calculator.Undo();
		System.out.println(a);
	}

}
