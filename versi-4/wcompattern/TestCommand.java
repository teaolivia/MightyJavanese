package wcompattern;
import java.lang.String;

public class TestCommand {
	public static void main (String[] args ){
		Calculator calculator = new Calculator();
//		Command showmem = new ShowMemCommand(calculator);
		Command showall = new ShowAllCommand(calculator);
//		Command redo = new RedoCommand(calculator);
//		Command undo = new UndoCommand(calculator);
		Command save = new SaveCommand(calculator);
		
		InputInvoker i = new InputInvoker();
		
		String str = "ShowAll";
		
		if (str == "ShowAll"){
			i.StoreAndExecute(showall);
		}else{
			i.StoreAndExecute(save);
		}
	}
}
