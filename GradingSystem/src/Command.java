import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Command {
	/*deal with command*/
	public void getCommand() throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {	
			String input = sc.nextLine();
			String[] substr = input.split("\\s+");
		
			if(input.equalsIgnoreCase("!help"))
				help();
			else if(substr[0].equalsIgnoreCase("R"))
				readFile(substr[1]);
			else if(substr[0].equalsIgnoreCase("IS") && substr[2].equalsIgnoreCase("-a"))
				IS_a(substr[1]);
			else if(substr[0].equalsIgnoreCase("IS") && substr[2].equalsIgnoreCase("-d"))
				IS_d(substr[1]);
			else if(substr[0].equalsIgnoreCase("QS") && substr[2].equalsIgnoreCase("-a"))
				QS_a(substr[1]);
			else if(substr[0].equalsIgnoreCase("QS") && substr[2].equalsIgnoreCase("-d"))
				QS_d(substr[1]);
			else if(substr[0].equalsIgnoreCase("HS") && substr[2].equalsIgnoreCase("-a"))
				HS_a(substr[1]);
			else if(substr[0].equalsIgnoreCase("HS") && substr[2].equalsIgnoreCase("-d"))
				HS_d(substr[1]);
			else if(substr[0].equalsIgnoreCase("ana") && substr[1].equalsIgnoreCase("math"))
				anaMath();
			else if(substr[0].equalsIgnoreCase("ana") && substr[1].equalsIgnoreCase("chin"))
				anaChin();
			else if(substr[0].equalsIgnoreCase("BS") && substr[1].equalsIgnoreCase("no")) {
				System.out.println("Please input no:");
				int no = Integer.parseInt(sc.nextLine());
				BSno(no);
			}
			else if(substr[0].equalsIgnoreCase("BS") && substr[1].equalsIgnoreCase("name")) {
				System.out.println("Please input name:");
				String name = sc.nextLine();
				BSname(name);
			}
			else if(input.equalsIgnoreCase("Quit")) {
				quit();
				sc.close();
				return;
			}
			else {
				System.out.println("Error: not legal command");
				sc.close();
				return;
			}
		}
		sc.close();
		getCommand();
	}

	public void help(){
		System.out.println("R \"filename\" to read a file");
		System.out.println("IS \"math, chin, no, name or average\" -a to insertsort data by ascending order");
		System.out.println("IS \"math, chin, no, name or average\" -d to insertsort data by descending order");
		System.out.println("QS \"math, chin, no, name or average\" -a to quicksort data by ascending order");
		System.out.println("QS \"math, chin, no, name or average\" -d to quicksort data by descending order");
		System.out.println("HS \"math, chin, no, name or average\" -a to heapsort data by ascending order");
		System.out.println("HS \"math, chin, no, name or average\" -d to heapsort data by descending order");
		System.out.println("ana math to statistical analysis math grade");
		System.out.println("ana chin to statistical analysis chinese grade");
		System.out.println("BS no to Binary search number you input");
		System.out.println("BS name to Binary search name you input");
	}
	
	public void readFile(String filename) throws NumberFormatException, IOException {
		System.out.println("Successfully read");
		StudentDB.readInDB(filename);
	}
	
	private void IS_a(String subject) {
		Sort.insertSort(StudentDB.getStudents(), getComparator(subject));
		StudentDB.showStudents();
	}
	
	private void IS_d(String subject) {
		Sort.insertSort(StudentDB.getStudents(), getComparator(subject));
		Collections.reverse(StudentDB.getStudents());
		StudentDB.showStudents();
	}
	
	private void QS_a(String subject) {
		Sort.quickSort(StudentDB.getStudents(), getComparator(subject));
		StudentDB.showStudents();
	}
	
	private void QS_d(String subject) {
		Sort.quickSort(StudentDB.getStudents(), getComparator(subject));
		Collections.reverse(StudentDB.getStudents());
		StudentDB.showStudents();
	}
	
	private void HS_a(String subject) {
		Sort.heapSort(StudentDB.getStudents(), getComparator(subject));
		StudentDB.showStudents();
	}
	
	private void HS_d(String subject) {
		Sort.heapSort(StudentDB.getStudents(), getComparator(subject));
		Collections.reverse(StudentDB.getStudents());
		StudentDB.showStudents();
	}
	
	private Comparator<Student> getComparator(String subject) {
		if(subject.equalsIgnoreCase("math"))
			return new MathComparator();
		else if(subject.equalsIgnoreCase("chin"))
			return new ChinComparator();
		else if(subject.equalsIgnoreCase("name"))
			return new NameComparator();
		else if(subject.equalsIgnoreCase("no"))
			return new IDComparator();
		else if(subject.equalsIgnoreCase("avg"))
			return new AvgComparator();
		return null;
	}
	
	private void anaMath() {
		Analysis ana = new Analysis();
		ana.anaMath();
		ana.showAna();
	}
	
	private void anaChin() {
		Analysis ana = new Analysis();
		ana.anaChin();
		ana.showAna();
	}
	
	private void BSno(int no) {
		ArrayList<Student> students = StudentDB.getStudents();
		int index ,len = students.size();
		StudentDB.ranking();
		Sort.quickSort(StudentDB.getStudents(), new IDComparator());
		index = BinarySearch.binarySearchID(students, 0, len - 1, no);
		students.get(index).showStudent();
	}
	
	private void BSname(String name) {
		ArrayList<Student> students = StudentDB.getStudents();
		int index ,len = students.size();
		
		StudentDB.ranking();
		Sort.quickSort(StudentDB.getStudents(), new NameComparator());
		index = BinarySearch.binarySearchName(students, 0, len - 1, name);
		students.get(index).showStudent();
	}
	
	public void quit() {
		System.out.println("Bye Bye");
	}
	
}
