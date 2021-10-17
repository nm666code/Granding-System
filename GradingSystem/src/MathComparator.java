import java.util.Comparator;

public class MathComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.getMath()-o2.getMath();
	}

}
