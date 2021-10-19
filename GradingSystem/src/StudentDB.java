import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class StudentDB {
	private static ArrayList<Student> students = new ArrayList<Student>();

	public static void addStudent(Student student) {
		students.add(student);
	}
	
	public static ArrayList<Student> getStudents() {
		return students;
	}

	public static void setStudents(ArrayList<Student> students) {
		StudentDB.students = students;
	}
	
	public static void ranking() {
		int i = students.size();
		Sort.quickSort(students, new AvgComparator());
		for(Student s:students) {
			s.setRank(i);
			i--;
		}
	}
	
	public static void writeOutDB(String fileName) {
		File file = new File(fileName);
		try (PrintWriter output = new PrintWriter(file);){
			for(Student s: students) {
				output.println(
					s.getId()+","+s.getName()+","+s.getChin()+","+s.getMath());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void readInDB(String fileName) throws NumberFormatException, IOException {
		ArrayList<Student> tempDB = new ArrayList<Student>();
		InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName));
		BufferedReader input = new BufferedReader(isr);
		try {
			String line = null;
			while ((line = input.readLine())!=null) {
				String item[] = line.split(",");
				Student s = new Student();
				s.setId(Integer.parseInt(item[0].trim()));
				s.setName(item[1].trim());
				s.setChin(Integer.parseInt(item[2].trim()));
				s.setMath(Integer.parseInt(item[3].trim()));
				tempDB.add(s);
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		students = tempDB;
		ranking();
	}
	
	public static void showStudents() {
		for(Student s: students) {
			s.showStudent();
		}
	}
}
