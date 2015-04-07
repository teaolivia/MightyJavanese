package wcompattern;
import java.io.Console;
import java.lang.Integer;

public class RedoCommand implements Command {
	private Calculator calculator;
	private int a =0; 
	
	public RedoCommand(Calculator calculator){
		this.calculator = calculator;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Console console = System.console();
		String s=console.readLine();
		int a = Integer.parseInt(console.readLine());
		calculator.Redo();
		System.out.println(a);
	}

}
