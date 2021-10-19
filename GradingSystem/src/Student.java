
public class Student {
	private int id;
	private String name;
	private int chin;
	private int math;
	private int rank;
	
	public Student() {
		this.setId(0);
		this.setName(null);
		this.setChin(0);
		this.setMath(0);
	}
	
	public Student(int id, String name, int chin, int math) {
		this.setId(id);
		this.setName(name);
		this.setChin(chin);
		this.setMath(math);
	}
	
	public void showStudent() {
		double avg = ((double)chin+(double)math)/2;
		avg = Math.round(avg*100.0)/100.0;
		System.out.println(
				"no="+id+", name="+name+", chin="+chin+rating(chin)+", math="+math+rating(math)
				+", AVG平均="+avg+rating((int)avg)+", 名次="+rank
				);
	}

	public String rating(int score) {
		if(score>= 90)
			return "(優)";
		else if(score >= 80)
			return "(甲)";
		else if(score >= 70)
			return "(乙)";
		else if(score >= 60)
			return "(丙)";
		else
			return "(丁)";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getChin() {
		return chin;
	}

	public void setChin(int chin) {
		this.chin = chin;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
}
