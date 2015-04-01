package api;
import java.util.Stack;
import java.lang.Character;
import java.lang.Integer; 
import java.lang.Boolean;

public interface ArithmaticCalculator {
	public void setStack(Stack<Character> stack);
	public Stack<Character> getStack();
	public int parsen();
	public int calculate(int opa1,int opa2, char opr);
	public void test();
	
}
