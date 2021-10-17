import java.util.Comparator;

public class ChinComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.getChin()-o2.getChin();
	}

}
