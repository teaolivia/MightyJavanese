package lib;
import java.util.Stack;
import java.util.stream.*;
import java.lang.Boolean; 
import java.lang.Integer; 
import java.util.*; 
import java.io.*;

public class CommandProcessing {
	private String command;
	private Stack<String> comms;
	public Command(){
		comms = new Stack<String>();
		command= "";
	}
	
	public void setCommand(String n){
		command= n; 
	}
	
	
	
	/*Daftar Command:
		
	* input command :<ekspresi>; output : Hasil ekspresi, sebuah angka atau sebuah nilai boolean
	* input command :ShowMem<n>; output : "Proses ShowMem 2"; jika parameter n yang diketikkan =2
	* input command :ShowAll   ; output : "Proses ShowMem Semua"
	* input command :Redo<n>   ; output : "Proses Redo 2"
	* input command :Undo<n>   ; output : "Proses Undo 2"
	* input command :Save	   ; output : "Proses Save"
	*/
	public String getCommand(){
		String input = "";
		switch(input){
			case "ShowMem":
				command = "ShowMem";
				break;
			case "ShowAll":
				command = "ShowMem semua";
				break; 
			case "Save": 
				command = "Save";
				break;
			default : command ="Invalid command";
		}
		return command;
	}
	
}
