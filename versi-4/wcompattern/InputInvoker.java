package wcompattern;
import java.util.ArrayList;
//import java.util.Stack; 
import java.util.List;

/*The invoker class*/ 
public class InputInvoker {
	private List<Command> input = new ArrayList<Command>();
	
	public InputInvoker(){}
	
	public void StoreAndExecute(Command command){
		this.input.add(command);
		command.execute();
	}
}
