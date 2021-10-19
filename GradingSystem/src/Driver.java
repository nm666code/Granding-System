import java.io.IOException;

public class Driver {

	public static void main(String[] args) {
		Command command = new Command();		
		System.out.println("Welcoe to Grading System");
		System.out.println("If you need help. Please input !help");
		System.out.println("I will show you all commands");
		System.out.println("Remember read data before you input any command which need data");
		try {
			command.getCommand();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
