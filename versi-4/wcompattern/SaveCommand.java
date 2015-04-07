package wcompattern;

public class SaveCommand implements Command {
	private Calculator calculator; 
	
	public SaveCommand(Calculator calculator){
		this.calculator = calculator;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		calculator.Save();
	}

}
