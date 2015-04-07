package wcompattern;

public class ShowAllCommand implements Command {
	private Calculator calculator; 
	
	public ShowAllCommand(Calculator calculator){
		this.calculator = calculator; 
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		calculator.ShowAll();
	}

}
