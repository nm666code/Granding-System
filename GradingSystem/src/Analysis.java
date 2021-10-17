import java.util.ArrayList;

public class Analysis {
	/*analysis student grade*/
	private int max;
	private int min;
	private double avg;
	private double SD;
	private int interval;
	private int[] distribution;
	
	
	public void anaChin() {
		ArrayList<Student> students = new ArrayList<Student>(StudentDB.getStudents());
		Sort.quickSort(students, new ChinComparator());
		max = students.get(students.size() - 1).getChin();
		min = students.get(0).getChin();
		
		int sum = 0;
		for(Student s:students) 
			sum += s.getChin();
		avg = sum / students.size();
		
		for(Student s:students) 
			SD += Math.pow((s.getChin() - avg), 2);
		SD /= students.size();
		SD = Math.sqrt(SD);
		
		if(interval!=0)
			distribution = new int[100/interval];
		else
			return;
		for(Student s:students) {
			int i = s.getChin()/interval;
			if(i >= distribution.length)
				i = distribution.length - 1;
			distribution[i]++;
		}
	}
	
	public void anaMath() {
		ArrayList<Student> students = new ArrayList<Student>(StudentDB.getStudents());
		Sort.quickSort(students, new ChinComparator());
		max = students.get(students.size() - 1).getMath();
		min = students.get(0).getMath();
		
		int sum = 0;
		for(Student s:students) 
			sum += s.getMath();
		avg = sum / students.size();
		
		for(Student s:students) 
			SD += Math.pow((s.getMath() - avg), 2);
		SD /= students.size();
		SD = Math.sqrt(SD);
		
		if(interval!=0)
			distribution = new int[100/interval];
		else
			return;
		for(Student s:students) {
			int i = s.getMath()/interval;
			if(i >= distribution.length)
				i = distribution.length - 1;
			distribution[i]++;
		}
	}
	
	public void showAna() {
		System.out.println("max:"+max+", min:"+min+", avg:"+avg+", standard deviation:"+SD);
		System.out.println("distribution"+"          interval:"+interval);
		for(int i = 0; i < distribution.length; i++) {
			if(i != distribution.length-1)
				System.out.println(i*interval+"~"+(i * (interval + 1) - 1)+":"+distribution[i]);
			else
				System.out.println("above "+i*interval+":"+distribution[i]);
		}
	}
}
