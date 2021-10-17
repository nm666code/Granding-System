import java.io.IOException;
import java.util.Scanner;

public class Command {
	/*deal with command*/
	public void getCommand() throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] substr = input.split("\\s+");
		
		if(input.equalsIgnoreCase("!help"))
			help();
		else if(substr[0].equalsIgnoreCase("R"))
			readFile(substr[1]);
		else if(input.equalsIgnoreCase("Quit")) {
			quit(); sc.close();}
		else
			System.out.println("Error: not legal command");
		getCommand();
	}
	
	public void help(){
		
	}
	
	public void readFile(String filename) throws NumberFormatException, IOException {
		StudentDB.readInDB(filename);
	}
	
	
	
	public void quit() {
		System.out.println("Bye Bye");
	}
	
}
