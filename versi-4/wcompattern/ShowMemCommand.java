package wcompattern;
import java.io.Console;
import java.lang.Integer;

public class ShowMemCommand implements Command {
	private Calculator calculator;
	private int a = 0;
	
	public ShowMemCommand(Calculator calculator){
		this.calculator = calculator;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Console console = System.console();
		String s=console.readLine();
		int a = Integer.parseInt(console.readLine());
		calculator.ShowMem();
		System.out.println(a);
	}

}
